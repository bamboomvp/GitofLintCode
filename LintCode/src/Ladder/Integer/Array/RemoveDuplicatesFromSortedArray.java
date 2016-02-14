package Ladder.Integer.Array;

public class RemoveDuplicatesFromSortedArray {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return 0;
    	}else if(nums.length == 1){
    		return 1;
    	}else{
    		int tail_index = 0;
    		int curr_index = 1;
    		while(curr_index < nums.length){
    			if(nums[curr_index] != nums[tail_index]){
    				tail_index++;
    				nums[tail_index] = nums[curr_index];
    			}
    			curr_index++;
    		}
    		return tail_index + 1;
    	}
    }
}
