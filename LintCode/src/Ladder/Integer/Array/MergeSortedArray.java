package Ladder.Integer.Array;

public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    	
    	int curr_idx = A.length - 1;
    	
    	while(m > 0 && n > 0){
    		if(A[m - 1] > B[n - 1]){
    			A[curr_idx] = A[m - 1];
    			m--;
    		}else{ 
    			A[curr_idx] = B[n - 1];
    			n--;
    		}
    		
    		curr_idx--;
    	}
    	
    	while(n > 0){
    		A[curr_idx] = B[n - 1];
    		n--;
    		curr_idx--;
    	}
    	
    	// no need to check the remaining elements in A...
    }
}
