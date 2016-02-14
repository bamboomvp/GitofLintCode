package Ladder.String;

public class LongestCommonPrefix {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){
			return "";
		}
		
    	int index = 0;
    	boolean flag = true;
    	while(flag){
			char tmp = 0;
			boolean flag2 = true;
			for(String curr_str : strs){
				if(curr_str.length() <= index){
					flag = false;
					break;
				}else{
					if(flag2){
						flag2 = false;
						tmp = curr_str.charAt(index);
					}else{
						if(curr_str.charAt(index) != tmp){
							flag = false;
							break;
						}
					}
				}
			}
			if(flag){
				index++;
			}
    	}
    	
    	return strs[0].substring(0, index);
    }
}
