package shaunwassel.learning;

import java.util.Random;

public class PasswordGenerator {
	
	String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
	String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
	String numberChars = "0123456789";
	
	String GeneratePassword(int length, boolean useUpperCase, boolean useLowerCase, boolean useNumbers, boolean useSpecialChars) {
		
		Random rand = new Random();
		StringBuilder password = new StringBuilder();
		StringBuilder charPoolBuilder = new StringBuilder();
		charPoolBuilder.append(useUpperCase ? this.uppercaseChars : ""); 
		charPoolBuilder.append(useLowerCase ? this.lowercaseChars : ""); 
		charPoolBuilder.append(useNumbers ? this.numberChars : ""); 
		charPoolBuilder.append(useSpecialChars ? this.specialChars : ""); 

		String charPool = charPoolBuilder.toString();
		// For loop to select characters
		for(int i = 0; i < length; i++) {
			password.append(charPool.charAt(rand.nextInt(charPool.length())));
		}
		
		return password.toString();
	}

}
