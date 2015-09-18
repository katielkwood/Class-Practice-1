package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
    private int numWrongGuesses;
    
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
        numWrongGuesses = 0;
    }
    
    public void setWord(String newWord) {
        this.word = newWord;
    }
    
    public boolean available(char c) {
    	return !usedLetters.contains(c);
    }
    
    public int guess(char c) {
    	int numOccurrences = 0;
    	for (int i = 0; i < word.length(); i++){
    		if (c == word.charAt(i)){
    			numOccurrences++;
    		}
    	}
    	if (numOccurrences == 0 && !usedLetters.contains(c)){
    		numWrongGuesses++;
    	}
    	usedLetters.add(c);
        return numOccurrences;
    }
    
    public Result getResult() {
    	if (numWrongGuesses >= 6){
    		return Result.LOSE;
    	}
    	else{
    		boolean allWordLettersUsed = true;
    		for (int i = 0; i < word.length(); i++){
	    		char letter = word.charAt(i);
    			if(!usedLetters.contains(letter)){
    				allWordLettersUsed = false;
    			}
    		}
    		if (allWordLettersUsed) return Result.WIN;
    		else return Result.NONE;
    	}
    }
    
}












