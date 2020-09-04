package telran.tests;
import static telran.words.Anagram.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnagramTests {
	String word = "yellow";
	
	@Test
	void testAnagramTrue() {
		assertTrue(isAnagram(word, "loweyl"));
		assertTrue(isAnagram(word, "elolyw"));
		assertTrue(isAnagram(word, "wolley"));
		assertTrue(isAnagram(word, "loleyw"));
	}
	
	@Test
	void testAnagramFalse() {
		assertFalse(isAnagram(word, "123"));
		assertFalse(isAnagram("a", "a"));
		assertFalse(isAnagram(word, "AbCd;"));
		assertFalse(isAnagram(word, ""));
		assertFalse(isAnagram("", ""));
		assertFalse(isAnagram(word, "yello"));
		assertFalse(isAnagram(word, "yelllo"));
		assertFalse(isAnagram(word, word));	
	}

}
