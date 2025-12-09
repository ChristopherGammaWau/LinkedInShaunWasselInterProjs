package shaunwassel.learning;

public class App {
	
	public static void main(String[] args) {
		UserInterface ui = new TextBasedInterface();
		PasswordGenerator gen = new PasswordGenerator();
		
		int length = ui.getPasswordLength();
		boolean useUpperCase = ui.useUpperCase();
		boolean useLowerCase = ui.useLowerCase();
		boolean useNumbers = ui.useNumbers();
		boolean useSpecialChars = ui.useSpecialChars();
		
		ui.displayPassword(gen.GeneratePassword(length, useUpperCase, useLowerCase, useNumbers, useSpecialChars));
		
	}

}

