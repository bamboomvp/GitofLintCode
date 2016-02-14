package Ladder.Integer.Array;

public class RemoveElement {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
    	int last_index = A.length - 1;
    	int curr_index = 0;
    	
    	// move to the last elem which is not the target elem
    	while(last_index >= 0 && A[last_index] == elem){
    		last_index--;
    	}
    	
    	// special case, all elems are the target elem
    	if(last_index < 0){
    		return 0;
    	}
    	
    	while(curr_index < last_index){
    		// if find, swithc with the "last" elem
    		if(A[curr_index] == elem){
    			A[curr_index] = A[last_index];
    			A[last_index] = elem;
    			while(curr_index < last_index && A[last_index] == elem){
    				last_index--;
    			}
    		}
    		
    		curr_index++;
    	}
    	
    	return last_index + 1;
    }
}
