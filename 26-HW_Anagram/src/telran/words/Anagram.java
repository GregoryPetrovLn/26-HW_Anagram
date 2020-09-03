package telran.words;

import java.util.*;

public class Anagram {

	// create only one map with appaying methods merge and compute
	public static boolean isAnagram(String word, String anagram) {
		if (!checker(word, anagram))
			return false;

		char charsWord[] = word.toLowerCase().toCharArray();
		char charsAnagram[] = anagram.toLowerCase().toCharArray();

		HashMap<String, Integer> mapWord = getMap(charsWord);
		
		//====================================//
		for (Map.Entry entry : mapWord.entrySet()) {
			System.out.println(entry);
		}
		System.out.println();
		//====================================//
		
//		for(char c : charsAnagram) {
//			String key = "" + c;
//			
//			
//		}
		
		
		

		return true;
	}

	/**
	 * 
	 * @param charsWord
	 * @return
	 */
	private static HashMap<String, Integer> getMap(char[] charsWord) {
		HashMap<String, Integer> res = new HashMap<>();
		for (char c : charsWord) {
			String key = "" + c;
			res.compute(key, (k ,v) -> (v == null) ? 1 : ++v);
		}

		return res;
	}

	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return
	 */
	private static boolean checker(String word, String anagram) {
		String regex = "[a-zA-Z]+{2}";

		if (!word.matches(regex) || !anagram.matches(regex))
			return false;

		if (word.equals(anagram))
			return false;

		if (word.length() != anagram.length())
			return false;

		return true;
	}

}
