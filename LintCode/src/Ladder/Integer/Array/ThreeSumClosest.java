package Ladder.Integer.Array;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
    	
    	Arrays.sort(numbers);
    	int globalVal = 0;
    	boolean firstFlag = true;
    	
    	for(int i = 0; i < numbers.length; i++){
    		int newTarget = target - numbers[i];
    		int m, n;
    		m = 0;
    		n = numbers.length - 1;
    		while(m < n){
    			if(m == i){
    				m++;
    			}else if(n == i){
    				n--;
    			}
    			
				if(m == n){
					break;
				}
				
				if(numbers[m] + numbers[n] < newTarget){
					if(firstFlag || Math.abs(numbers[i] + numbers[m] + numbers[n] - target) < Math.abs(globalVal - target)){
						firstFlag = false;
						globalVal = numbers[i] + numbers[m] + numbers[n];
					}
					m++;
				}else if(numbers[m] + numbers[n] > newTarget){
					if(firstFlag || Math.abs(numbers[i] + numbers[m] + numbers[n] - target) < Math.abs(globalVal - target)){
						firstFlag = false;
						globalVal = numbers[i] + numbers[m] + numbers[n];
					}					
					n--;
				}else{
					return target; // special shortcut
				}
    		}
    	}
    	
    	return globalVal;
    }
}
