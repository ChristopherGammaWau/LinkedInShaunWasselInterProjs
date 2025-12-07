package shaunwassel.learning;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class DiceRollingApp {

	public static void main(String[] args) {
		boolean isRunning = true;
		Scanner input = new Scanner(System.in);// Here so catch an access it
		do {
		// Challenge : Loops until user inputs "exit", not just when user inputs valid number
		try {
			// Get number of dice

			
			System.out.println("How many dice to roll?");
			int numberOfDice = input.nextInt();
			
			System.out.println(String.format("Rolling %d number of dice.", numberOfDice));
			
			Random randomGenerator = new Random();
			
			for (int i = 0; i < numberOfDice; i++) {
				System.out.println(displayDice(randomGenerator.nextInt(6) + 1));
			}
		}
		catch (InputMismatchException e) {
			// Challenge: Try to see if it's actually the "exit" string, else print error message.
			String lineStr = input.nextLine();
			if("Exit".equalsIgnoreCase(lineStr)) {
				isRunning = false;
			}
			else {
				System.out.println("Please enter valid integer or \"exit\"");
			}
		}
		}
		while(isRunning);

	}
	
	static String displayDice(int diceNum) {
		return switch(diceNum) {
		case 1 -> "-----\r\n"
				+ "|   |\r\n"
				+ "| o |\r\n"
				+ "|   |\r\n"
				+ "-----";
		case 2 -> "-----\r\n"
				+ "|o  |\r\n"
				+ "|   |\r\n"
				+ "|  o|\r\n"
				+ "-----";
		case 3 -> "-----\r\n"
				+ "|o  |\r\n"
				+ "| o |\r\n"
				+ "|  o|\r\n"
				+ "-----";
		case 4 -> "-----\r\n"
				+ "|o o|\r\n"
				+ "|   |\r\n"
				+ "|o o|\r\n"
				+ "-----";
		case 5 -> "-----\r\n"
				+ "|o o|\r\n"
				+ "| o |\r\n"
				+ "|o o|\r\n"
				+ "-----";
		case 6 -> "-----\r\n"
				+ "|o o|\r\n"
				+ "|o o|\r\n"
				+ "|o o|\r\n"
				+ "-----";
		default -> "Unexpected value!";
		
		};
	}

}
