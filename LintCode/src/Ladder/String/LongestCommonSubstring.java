package Ladder.String;

public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
    	if(A == null || A.isEmpty() || B == null || B.isEmpty()){
    		return 0;
    	}
    	
    	String str1 = A.toLowerCase();
    	String str2 = B.toLowerCase();
    	
    	int[][] num = new int[str1.length()][str2.length()];
    	int maxLen = 0;
    	for(int i = 0; i < str1.length(); i++){
    		for(int j = 0; j < str2.length(); j++){
    			if(str1.charAt(i) == str2.charAt(j)){
    				if(i == 0 || j == 0){
    					num[i][j] = 1;
    				}else{
    					num[i][j] = num[i-1][j-1] + 1;
    				}
    				
    				if(num[i][j] > maxLen){
    					maxLen = num[i][j];
    				}
    			}else{
    				num[i][j] = 0;
    			}
    		}
    	}
    	
    	return maxLen;
    }
}
