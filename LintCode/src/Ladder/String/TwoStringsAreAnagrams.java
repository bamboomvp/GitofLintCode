package Ladder.String;

import java.util.HashMap;
import java.util.Map;

public class TwoStringsAreAnagrams {
	
	private static final Map<Character, Integer> lookupTable = new HashMap<>();
	
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // special cases
    	if(s == null || t == null){
    		return false;
    	}else if(s.isEmpty() || t.isEmpty()){
    		return false;
    	}else if(s.length() != t.length()){
    		return false;
    	}else{
    		lookupTable.clear();
    		
    		for(Character curr_char : s.toCharArray()){
    			if(lookupTable.containsKey(curr_char)){
    				lookupTable.put(curr_char, lookupTable.get(curr_char) + 1);
    			}else{
    				lookupTable.put(curr_char, 1);
    			}
    		}
    		
    		for(Character curr_char : t.toCharArray()){
    			if(lookupTable.containsKey(curr_char)){
    				lookupTable.put(curr_char, lookupTable.get(curr_char) - 1);
    			}else{
    				lookupTable.put(curr_char, -1);
    			}
    		}
    		
    		for(Integer i : lookupTable.values()){
    			if(i != 0){
    				return false;
    			}
    		}
    		
    		return true;
    	}
    }
}
