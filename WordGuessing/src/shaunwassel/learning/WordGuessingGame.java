package shaunwassel.learning;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

	private String wordToGuess;
	private char[] guessedLetters;
	private int attemptsRemaining; // Decrease by one each user guess

	public WordGuessingGame(String[] wordList, int maxAttempts) {

		Random randIndex = new Random();
		this.wordToGuess = wordList[randIndex.nextInt(wordList.length)];
		this.guessedLetters = new char[this.wordToGuess.length()];
		// Init array content
		for (int i = 0; i < guessedLetters.length; i++) {
			guessedLetters[i] = '_';
		}
		this.attemptsRemaining = maxAttempts;

	}

	/**
	 * Starts 1 session of the console game.
	 * Returns true if user wins the game.
	 */
	public boolean Play() {
		// TEST See what word is being guessed
		System.out.println("Word being guessed: " + this.wordToGuess);

		boolean isUserWin = false;
		Scanner userInputScanner = new Scanner(System.in);

		while (this.attemptsRemaining > 0 && !isUserWin) {
			System.out.println(String.format("You have %d attempts left..", this.attemptsRemaining));
			System.out.println("Guess progress: " + new String(this.guessedLetters));
			System.out.print("Guess a letter: ");
			try {
				char charGuess = userInputScanner.nextLine().toLowerCase().charAt(0);
				if (tryGuessLetter(charGuess)) {
					System.out.println("Right guess.");

					if (new String(this.guessedLetters).equals(this.wordToGuess.toLowerCase())) {
						isUserWin = true;
					}
				} else {
					this.attemptsRemaining--;
					System.out.println("Wrong guess!!");

				}
			} catch (NoSuchElementException e) {
				System.out.println("Please enter 1 valid character!!");
			}

		}

		// Game over
		System.out.println("Game over!");
		if (isUserWin) {
			System.out.println("You win! The word is: " + this.wordToGuess);
			return true;

		}
		else {
			return false;
		}
	}


	/**
	 * Checks if letter from user input is found in the word (case-insensitive).
	 * Returns true is a letter is found in the word.
	 */
	private boolean tryGuessLetter(char letter) {
		boolean letterFound = false;
		for (int i = 0; i < this.wordToGuess.length(); i++) {
			if (this.wordToGuess.toLowerCase().charAt(i) == letter) {
				this.guessedLetters[i] = letter;
				letterFound = true;
			}
		}
		return letterFound;
	}

}
