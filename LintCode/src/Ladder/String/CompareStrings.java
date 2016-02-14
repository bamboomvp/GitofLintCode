package Ladder.String;

public class CompareStrings {
	
	private static final int arrLen = 26;
	private static final int[] letters = new int[arrLen];
	private static final int offset = 65;
	
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
    	if(A == null || B == null){
    		return false;
    	}
    	
    	for(int i = 0; i < arrLen; i++){
    		letters[i] = 0;
    	}
    	
    	for(char curr_char : A.toCharArray()){
    		letters[curr_char - offset] += 1; 
    	}
    	
    	for(char curr_char : B.toCharArray()){
    		letters[curr_char - offset] -= 1;
    		if(letters[curr_char-offset] < 0){
    			return false;
    		}
    	}
    	
    	return true;
    }
}
