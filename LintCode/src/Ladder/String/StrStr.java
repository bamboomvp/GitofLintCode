package Ladder.String;

public class StrStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
       if(source == null || target == null){
    	   return -1;
       }else if(source.isEmpty() && target.isEmpty()){
    	   return 0;
       }else{
    	   for(int base = 0; base < source.length(); base++){
    		   if(source.length() - base < target.length()){
    			   return -1;
    		   }else{
    			   boolean flag = true;
    			   for(int index = 0; index < target.length(); index++){
    				   if(target.charAt(index) != source.charAt(base + index)){
    					   flag = false;
    					   break;
    				   }
    			   }
    			   if(flag){
    				   return base;
    			   }else{
    				   continue;
    			   }
    		   }
    	   }
    	   
    	   return -1;
       }
    }
    
    private void cal_prefix(int[] prefix_arr, String target){
    	prefix_arr[0] = 0;
    	int magic_num = 0;
    	for(int i = 1; i < target.length(); i++){
    		while(magic_num > 0 && prefix_arr[magic_num] != prefix_arr[i]){
    			magic_num = prefix_arr[magic_num-1];
    		}
    		
    		if(prefix_arr[magic_num] == prefix_arr[i]){
    			magic_num++;
    		}
    		prefix_arr[i] = magic_num;
    	}
    }
    
    public int strStr_KMP(String source, String target) {
    	
    	// special cases
    	if(source == null || target == null)
    		return -1;
    	
    	if(target.isEmpty())
    		return 0;
    	
    	// prepare the "prefix function"
    	int[] prefix_arr = new int[target.length()];
    	cal_prefix(prefix_arr, target);
    	
    	// do the real string matching
    	int s_len = source.length();
    	int t_len = target.length();
    	int i, j, match_ptr;
    	i = j = match_ptr = 0;
    	
    	while(s_len - match_ptr >= t_len){
    		while(j < t_len && target.charAt(j) == source.charAt(i)){
    			j++;
    			i++;
    		}
    		
    		// ending case, found
    		if(j == t_len){
    			return match_ptr;
    		}
    		
    		// failed at the 1st char...
    		if(i == match_ptr){
    			i++;
    			match_ptr = i;
    			j = 0;
    		}else{
    			if(prefix_arr[j-1] > 0){
    				match_ptr = i - prefix_arr[j-1];
    				j = prefix_arr[j-1];
    			}else{
    				match_ptr = i;
    				j = 0;
    			}
    		}
    	}
    	
    	return -1;
    }
}
