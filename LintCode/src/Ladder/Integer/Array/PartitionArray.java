package Ladder.Integer.Array;

public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
    	int smallHead = 0; 
    	int bigHead = nums.length - 1;
    	
    	while(smallHead < bigHead){
    		while(smallHead < nums.length && nums[smallHead] < k){
    			smallHead++;
    		}
    		
    		while(bigHead >= 0 && nums[bigHead] >= k){
    			bigHead--;
    		}
    		
    		if(smallHead < bigHead){
    			int tmp = nums[smallHead];
    			nums[smallHead] = nums[bigHead];
    			nums[bigHead] = tmp;
    		}
    	}
    	
    	return bigHead + 1;
    }
}
