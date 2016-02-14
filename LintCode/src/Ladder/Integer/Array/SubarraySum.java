package Ladder.Integer.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
    	
        // O(n^2) solution
    	int[] sum_nums = new int[nums.length];
    	int curr_num = 0;
    	for(int i = 0; i < nums.length; i++){
    		curr_num += nums[i];
    		sum_nums[i] = curr_num;
    	}
    	
    	for(int i = 0; i < sum_nums.length; i++){
    		for(int j = 0; j <= i; j++){
    			if(j == i && nums[j] == 0){
    				return new ArrayList<>(Arrays.asList(j, i));
    			}
    			
    			if(j == 0 && sum_nums[i] == 0){
    				return new ArrayList<>(Arrays.asList(j, i));
    			}

    			if(j != 0 && sum_nums[i] - sum_nums[j - 1] == 0){
    				return new ArrayList<>(Arrays.asList(j, i));
    			}
    		}
    	}
    	
    	return new ArrayList<>(Arrays.asList(0, 0));
    }
    
    public ArrayList<Integer> subarraySum_alt(int[] nums) {
    	
    	// O(n) time and O(n) space solution.
    	Map<Integer, Integer> reserved_tbl = new HashMap<>();
    	int culcum_num = 0;
    	for(int i = 0; i < nums.length; i++){
    		culcum_num += nums[i];
    		if(nums[i] == 0){
    			return new ArrayList<>(Arrays.asList(i, i));
    		}else if(culcum_num == 0){
    			return new ArrayList<>(Arrays.asList(0, i));
    		}else if(reserved_tbl.containsKey(culcum_num)){
    			return new ArrayList<>(Arrays.asList(reserved_tbl.get(culcum_num) + 1, i));
    		}else{
    			reserved_tbl.put(culcum_num, i);
    		}
    	}
    	
    	return new ArrayList<>(Arrays.asList(0, 0));
    }
}
