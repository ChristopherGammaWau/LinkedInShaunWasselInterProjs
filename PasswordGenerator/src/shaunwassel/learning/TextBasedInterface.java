package shaunwassel.learning;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TextBasedInterface implements UserInterface{
	
	private Scanner scanner;
	
	public TextBasedInterface() {
		
		this.scanner = new Scanner(System.in);
		
	}

	@Override
	public int getPasswordLength() {
		System.out.println("Please enter password length: ");
		int length = 0;
		while(!(length > 0)) {
			try {
				length = this.scanner.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Please enter a valid number!");
			}
		}
		return length;
	}

	@Override
	public boolean useLowerCase() {
		System.out.println("Use lowercase characters? (y/n): ");
		boolean isInvalidInput = true;
		boolean charFlag = false;
		try {
			do {

				char userInput = scanner.nextLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'y':
					isInvalidInput = true;
					charFlag = true;
					break;
				case 'n':
					System.out.println("Goodbye!");
					isInvalidInput = true;
					charFlag = false;
					break;
				default:
					System.out.println("Please enter \'Y\' or \'N\'");
					isInvalidInput = false;
				}

			}while (isInvalidInput);
		} catch (NoSuchElementException e) {
			System.out.println("Please enter 1 valid character!!");
		}
		return charFlag;
	}

	@Override
	public boolean useUpperCase() {
		System.out.println("Use uppercase characters? (y/n): ");
		boolean isInvalidInput = true;
		boolean charFlag = false;
		try {
			do {

				char userInput = scanner.nextLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'y':
					isInvalidInput = true;
					charFlag = true;
					break;
				case 'n':
					System.out.println("Goodbye!");
					isInvalidInput = true;
					charFlag = false;
					break;
				default:
					System.out.println("Please enter \'Y\' or \'N\'");
					isInvalidInput = false;
				}

			}while (isInvalidInput);
		} catch (NoSuchElementException e) {
			System.out.println("Please enter 1 valid character!!");
		}
		return charFlag;
	}

	@Override
	public boolean useNumbers() {
		System.out.println("Use number characters? (y/n): ");
		boolean isInvalidInput = true;
		boolean charFlag = false;
		try {
			do {

				char userInput = scanner.nextLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'y':
					isInvalidInput = true;
					charFlag = true;
					break;
				case 'n':
					System.out.println("Goodbye!");
					isInvalidInput = true;
					charFlag = false;
					break;
				default:
					System.out.println("Please enter \'Y\' or \'N\'");
					isInvalidInput = false;
				}

			}while (isInvalidInput);
		} catch (NoSuchElementException e) {
			System.out.println("Please enter 1 valid character!!");
		}
		return charFlag;
	}

	@Override
	public boolean useSpecialChars() {
		System.out.println("Use special characters? (y/n): ");
		boolean isInvalidInput = true;
		boolean charFlag = false;
		try {
			do {

				char userInput = scanner.nextLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'y':
					isInvalidInput = true;
					charFlag = true;
					break;
				case 'n':
					System.out.println("Goodbye!");
					isInvalidInput = true;
					charFlag = false;
					break;
				default:
					System.out.println("Please enter \'Y\' or \'N\'");
					isInvalidInput = false;
				}

			}while (isInvalidInput);
		} catch (NoSuchElementException e) {
			System.out.println("Please enter 1 valid character!!");
		}
		return charFlag;
	}

	@Override
	public void displayPassword(String password) {
		System.out.println("Password: " + password);
		
	}

}
