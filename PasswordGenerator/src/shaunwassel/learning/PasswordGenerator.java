package shaunwassel.learning;

import java.util.Random;

public class PasswordGenerator {
	
	String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
	String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String specialChars = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
	String numberChars = "0123456789";
	
	/**
	 * Checks if s2 contains a character from s1
	 * @param s1: String 
	 * @param s2: String
	 * @return: Boolean, true if overlap
	 */
	private boolean hasOverlap(String s1, String s2) {
		for (char c : s1.toCharArray()) {
			if (s2.contains(String.valueOf(c))) {
				return true;
			}
		}
		return false;
	}
	
	String GeneratePassword(int length, boolean useUpperCase, boolean useLowerCase, boolean useNumbers, boolean useSpecialChars) {
		
		boolean doPasswordFitCriteria = false;
		Random rand = new Random();
		
		StringBuilder charPoolBuilder = new StringBuilder();
		charPoolBuilder.append(useUpperCase ? this.uppercaseChars : ""); 
		charPoolBuilder.append(useLowerCase ? this.lowercaseChars : ""); 
		charPoolBuilder.append(useNumbers ? this.numberChars : ""); 
		charPoolBuilder.append(useSpecialChars ? this.specialChars : ""); 
		String charPool = charPoolBuilder.toString();
		StringBuilder password;
		// Solution: Check if password fits criteria, regenerate if not
		do {
			password = new StringBuilder();
			
			// For loop to select characters
			for(int i = 0; i < length; i++) {
				password.append(charPool.charAt(rand.nextInt(charPool.length())));
			}
			
			// TODO: Improve nested if statements
			if(!useLowerCase || this.hasOverlap(this.lowercaseChars, password.toString())) {
				if(!useUpperCase || this.hasOverlap(this.uppercaseChars, password.toString())) {
					if(!useNumbers ||this.hasOverlap(this.numberChars, password.toString())) {
						if(!useSpecialChars ||this.hasOverlap(this.specialChars, password.toString())) {
							doPasswordFitCriteria = true;
						}
					}
				}
			}
			
		} while (!doPasswordFitCriteria);
		
		return password.toString();
	}

}
