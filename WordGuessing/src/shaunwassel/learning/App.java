package shaunwassel.learning;

public class App {

	public static void main(String[] args) {
		String[] wordList = { "work", "yoke", "invincible", "certain", "caption", "point", "ants", "many", "youthful",
				"canvass", "decisive", "respect", "cooperative", "grieving", "creepy", "" };
		WordGuessingMain appInstance = new WordGuessingMain(wordList, 10);
		appInstance.Play();
	}

}
