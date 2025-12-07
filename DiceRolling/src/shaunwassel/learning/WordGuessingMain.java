package shaunwassel.learning;

import java.util.Random;

public class WordGuessingMain {
	
	private String wordToGuess;
	private char[] guessedLetters;
	private int attemptsRemaining; // Decrease by one each user guess

	public WordGuessingMain(String[] wordList, int maxAttempts) {
		
		Random randIndex = new Random();
		this.wordToGuess = wordList[randIndex.nextInt(wordList.length)];
		this.guessedLetters = new char[this.wordToGuess.length()];
		// Init array content
		for(int i = 0; i < guessedLetters.length; i++) {
			guessedLetters[i] = '_';
		}
		this.attemptsRemaining = maxAttempts; 

	}

}
