package Ladder.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
    	List<String> res = new ArrayList<>();
    	
    	Map<String, ArrayList<Integer>> lookups = new HashMap<String, ArrayList<Integer>>();
    	
    	for(int i = 0; i < strs.length; i++){
    		char[] curr_str = strs[i].toCharArray();
    		Arrays.sort(curr_str);
    		String new_str = String.valueOf(curr_str);
    		if(!lookups.containsKey(new_str)){
    			lookups.put(new_str, new ArrayList<Integer>());
    		}
    		lookups.get(new_str).add(i);
    	}
    	
    	for(List<Integer> curr_list : lookups.values()){
    		if(curr_list.size() > 1){
    			for(int index : curr_list){
    				res.add(strs[index]);
    			}
    		}
    	}
    	
    	return res;
    }
}
