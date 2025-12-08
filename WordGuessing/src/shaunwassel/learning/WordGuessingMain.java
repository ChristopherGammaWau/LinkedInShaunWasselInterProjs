package shaunwassel.learning;

import java.util.NoSuchElementException;
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
		// TEST See what word is being guessed
		System.out.println("Word being guessed: " + this.wordToGuess);
		Scanner userInputScanner = new Scanner(System.in);
		
		// Get user guesses
		while(this.attemptsRemaining > 0) {
			System.out.println(String.format("You have %d attempts left..", this.attemptsRemaining));
			System.out.print("Guess a letter: ");
			try {
				char charGuess = userInputScanner.nextLine().charAt(0);
				if (tryGuessLetter(charGuess)) {
					System.out.println("Right guess.");
				}
				else {
					this.attemptsRemaining--;
					System.out.println("Wrong guess!!");
					
				}
			}
			catch (NoSuchElementException e) {
				System.out.println("Please enter 1 valid character!!");
			}
			
			
		}
	}
	
	/**
	 * Checks if letter from user input is found in the word (case-insensitive).
	 * Returns true is a letter is found in the word.
	 */
	private boolean tryGuessLetter(char letter) {
		boolean letterFound = false;
		for (int i = 0; i < this.wordToGuess.length(); i++) {
			if (Character.toLowerCase(this.wordToGuess.charAt(i)) == Character.toLowerCase(letter)) {
				this.guessedLetters[i] = letter;
				letterFound = true;
			}
		}
		return letterFound;
	}

}
