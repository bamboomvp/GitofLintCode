package Ladder.Integer.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
    	
    	Map<Integer, Integer> lookUp = new HashMap<>();
    	Set<String> answers = new HashSet<>();
    	
    	for(int k = 0; k < numbers.length; k++){
    		if(lookUp.containsKey(numbers[k])){
    			lookUp.put(numbers[k], lookUp.get(numbers[k]) + 1);
    		}else{
    			lookUp.put(numbers[k], 1);
    		}
    	}
    	
    	int a, b, c;
    	List<Integer> candidate = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	for(int x = 0; x < numbers.length; x++){
    		a = numbers[x];
    		for(int y = 0; y < numbers.length; y++){
    			if(y != x){
    				b = numbers[y];
    				c = -(a + b);
    				if(c == a && c == b){
    					if(lookUp.get(c) < 3)
    						continue;
    				}else if(c == a || c == b){
    					if(lookUp.get(c) < 2)
    						continue;
    				}else{
    					if(!lookUp.containsKey(c))
    						continue;
    				}
    				
    				candidate.clear();
    				candidate.add(a);
    				candidate.add(b);
    				candidate.add(c);
    				Collections.sort(candidate);
    				sb.setLength(0);
    				sb.append(candidate.get(0));
    				sb.append(",");
    				sb.append(candidate.get(1));
    				sb.append(",");
    				sb.append(candidate.get(2));
    				answers.add(sb.toString());
    			}
    		}
    	}
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	
    	for(String str : answers){
    		String[] splited = str.split(",");
    		ArrayList<Integer> curr = new ArrayList<>();
    		curr.add(Integer.valueOf(splited[0]));
    		curr.add(Integer.valueOf(splited[1]));
    		curr.add(Integer.valueOf(splited[2]));
    		res.add(curr);
    	}
    	
    	return res;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum_backup(int[] numbers) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
    	if(numbers.length < 3)
    		return result;
     
    	// sort array
    	Arrays.sort(numbers);
     
    	for (int i = 0; i < numbers.length - 2; i++) {
    		// //avoid duplicate solutions
    		if (i == 0 || numbers[i] > numbers[i - 1]) {
     
    			int negate = -numbers[i];
     
    			int start = i + 1;
    			int end = numbers.length - 1;
     
    			while (start < end) {
    				//case 1
    				if (numbers[start] + numbers[end] == negate) {
    					ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(numbers[i]);
    					temp.add(numbers[start]);
    					temp.add(numbers[end]);
     
    					result.add(temp);
    					start++;
    					end--;
    					//avoid duplicate solutions
    					while (start < end && numbers[end] == numbers[end + 1])
    						end--;
     
    					while (start < end && numbers[start] == numbers[start - 1])
    						start++;
    				//case 2
    				} else if (numbers[start] + numbers[end] < negate) {
    					start++;
    				//case 3
    				} else {
    					end--;
    				}
    			}
     
    		}
    	}
     
    	return result;
    }
}
