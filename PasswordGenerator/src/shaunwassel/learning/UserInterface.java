package shaunwassel.learning;

public interface UserInterface {

	public int getPasswordLength();
	public boolean useLowerCase();
	public boolean useUpperCase();
	public boolean useNumbers();
	public boolean useSpecialChars();
	public void displayPassword(String password);
	
}
