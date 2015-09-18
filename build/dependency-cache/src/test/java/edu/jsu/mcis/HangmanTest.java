package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class HangmanTest {
    
    // Exam Question 1
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testAllLettersAvailableAtBeginning() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        String allLetters = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < allLetters.length(); i++) {
            assertTrue(h.available(allLetters.charAt(i)));
        }
    }

    // Exam Question 2
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterMakesItUnavailable() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        boolean eIsAvailable = h.available('e');
        assertTrue(eIsAvailable);
        int numOccurrences = h.guess('e');
        eIsAvailable = h.available('e');
        assertFalse(eIsAvailable);
    }
    
    // Exam Question 3
    // Implement the Hangman guess() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterReturnsCorrectOccurrences() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        int numOccurrences = h.guess('e');
        assertEquals(2, numOccurrences);
    }
    
    // Exam Question 4
    // Implement this unit test to ensure that six or more missed
    // letters before the word is guessed results in a loss. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testSixOrMoreMissesCausesALoss() {
    	Hangman h = new Hangman();
    	h.setWord("inconceivable");
    	int dOccurrences = h.guess('d');
    	assertEquals(Hangman.Result.NONE, h.getResult());
    	int fOccurrences = h.guess('f');
    	assertEquals(Hangman.Result.NONE, h.getResult());
    	int gOccurrences = h.guess('g');
    	assertEquals(Hangman.Result.NONE, h.getResult());
    	int hOccurrences = h.guess('h');
    	assertEquals(Hangman.Result.NONE, h.getResult());
    	int jOccurrences = h.guess('j');
    	assertEquals(Hangman.Result.NONE, h.getResult());
    	int kOccurrences = h.guess('k');
    	
        assertEquals(Hangman.Result.LOSE, h.getResult());
    }
    
    // Exam Question 5
    // Implement this unit test to ensure that guessing all the 
    // letters correctly before six misses results in a win. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testGuessingEveryLetterBeforeSixMissesCausesAWin() {
    	Hangman h = new Hangman();
    	h.setWord("inconceivable");
    	int dOccurrences = h.guess('d'); //incorrect1
    	int aOccurrences = h.guess('a'); //---------a---
    	int fOccurrences = h.guess('f'); //incorrect2
    	int cOccurrences = h.guess('c'); //--c--c---a---
    	int eOccurrences = h.guess('e'); //--c--ce--a--e
    	int gOccurrences = h.guess('g'); //incorrect3
    	int bOccurrences = h.guess('b'); //--c--ce--ab-e
    	int iOccurrences = h.guess('i'); //i-c--cei-ab-e
    	int hOccurrences = h.guess('h'); //incorrect4
    	int nOccurrences = h.guess('n'); //inc-ncei-ab-e
    	int oOccurrences = h.guess('o'); //inconcei-ab-e
    	int jOccurrences = h.guess('j'); //incorrect5
    	int vOccurrences = h.guess('v'); //inconceivab-e
    	int lOccurrences = h.guess('l'); //inconceivable
    	
        assertEquals(Hangman.Result.WIN, h.getResult());
    }
    
}
