package Ladder.Integer.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfArrayExcludeItself {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
    	
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return result;
        }
        //leftToI = A[0] * ... * A[i-1] 
        long leftToI = 1;
        result.add(leftToI);
        for (int i = 1; i < A.size(); i++) {
            leftToI *= A.get(i-1);
            result.add(leftToI);
        }
        //rightToI = A[i-1] * A[i+1] * ... * A[n-1]
        long rightToI = 1;
        result.set(A.size() - 1, result.get(A.size() - 1) * rightToI);
        for (int i = A.size()-2; i >= 0; i--) {
            rightToI *= A.get(i+1);
            result.set(i, result.get(i) * rightToI);
        }
        return result;
    }	
	
	// Why this cannot work?????????
//    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
//    	   	
//    	Long[] res = new Long[A.size()];
//    	long[] helperArr1 = new long[A.size()];
//    	long[] helperArr2 = new long[A.size()];
//    	
//    	int base1 = 1;
//    	for(int i = 0; i < A.size(); i++){
//    		base1 *= A.get(i);
//    		helperArr1[i] = base1;
//    	}
//    	
//    	int base2 = 1;
//    	for(int j = A.size() - 1; j >=0; j--){
//    		base2 *= A.get(j);
//    		helperArr2[j] = base2;
//    	}
//    	
//    	for(int k = 0; k < A.size(); k++){
//    		if(k == 0){
//    			res[k] = helperArr2[k + 1];
//    		}else if(k == A.size() - 1){
//    			res[k] = helperArr1[k - 1];
//    		}else{
//    			res[k] = helperArr1[k - 1] * helperArr2[k + 1];
//    		}
//    	}
//    	
//    	return new ArrayList<Long>(Arrays.asList(res));
//    }
}
