package Ladder.String;

public class TestAnagrams {
	public static void main(String[] args){
		String[] strs = new String[]{"tea", "and", "ate", "eat", "den"};
		
		Anagrams program = new Anagrams();
		program.anagrams(strs);
	}
}
