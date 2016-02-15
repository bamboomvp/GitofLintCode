package Ladder.Integer.Array;

public class FirstMissingPositive {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
		//Given [1,2,0] return 3,
		//	and [3,4,-1,1] return 2.
    	//
		//	Your algorithm should run in O(n) time and uses constant space.
    	
    	for(int i = 0; i < A.length; i++){
    		if(A[i] >= 1 && A[i] <= A.length){
    			if(A[A[i] - 1] != A[i]){
    				int tmp = A[A[i] - 1];
    				A[A[i] - 1] = A[i];
    				A[i] = tmp;
    				i--; // search the position again
    			}
    		}
    	}
    	
    	for(int j = 0; j < A.length; j++){
    		if(A[j] != j + 1){
    			return j + 1;
    		}
    	}
    	
    	return A.length + 1;
    }
}
