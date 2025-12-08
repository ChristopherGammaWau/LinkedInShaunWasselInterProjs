package shaunwassel.learning;

import java.util.Random;
import java.util.Scanner;

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
	
	/**
	 * Starts the console game.
	 * */
	public void Play() {
		Scanner userInputScanner = new Scanner(System.in);
		
		// Get user guesses
		while(this.attemptsRemaining > 0) {
			System.out.println(String.format("You have %d attempts left..", this.attemptsRemaining));
			System.out.print("Guess a letter: ");
			
			
			this.attemptsRemaining--;
		}
	}

}
