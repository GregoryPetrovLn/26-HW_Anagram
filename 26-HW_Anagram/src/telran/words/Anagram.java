package telran.words;

import java.util.*;

public class Anagram {
	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return
	 */
	public static boolean isAnagram(String word, String anagram) {
		if (!isWalid(word, anagram))
			return false;

		char charsWord[] = word.toLowerCase().toCharArray();
		char charsAnagram[] = anagram.toLowerCase().toCharArray();

		HashMap<String, Integer> mapWord = getMap(charsWord);

		for (char c : charsAnagram) {
			String key = "" + c;

			int res = mapWord.merge(key, -1, (v1, v2) -> v1 + v2);
			
			if (res == -1) {
				return false;
			}
		}

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
			res.compute(key, (k, v) -> (v == null) ? 1 : ++v);
		}

		return res;
	}

	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return
	 */
	private static boolean isWalid(String word, String anagram) {
		String regex = "[a-zA-Z]+";

		if (!word.matches(regex) || !anagram.matches(regex))
			return false;

		if (word.equals(anagram))
			return false;

		if (word.length() != anagram.length())
			return false;
		
		if (word.length() < 3)
			return false;

		return true;
	}

}
