package Ladder.Integer.Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
    	
    	Map<Integer, Integer> lookUp = new HashMap<>();
    	
    	for(int i = 0; i < numbers.length; i++){
    		lookUp.put(numbers[i], i + 1);
    	}
    	
    	int index1 = -1;
    	int index2 = -1;
    	for(int j = 0; j < numbers.length; j++){
    		int candidate = target - numbers[j];
    		if(lookUp.containsKey(candidate) && (j + 1 != lookUp.get(candidate))){
    			index1 = j + 1;
    			index2 = lookUp.get(candidate);
    			break;
    		}
    	}
    	
    	return new int[]{index1, index2};
    }
}
