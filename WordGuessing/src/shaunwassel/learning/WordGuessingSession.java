package shaunwassel.learning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordGuessingSession {

	private String[] wordList = { "work", "yoke", "invincible", "certain", "caption", "point", "ants", "many",
			"youthful", "canvass", "decisive", "respect", "cooperative", "grieving", "creepy", "" };
	private SaveObject saveInstance;
	private String saveFilePath = "./savefile.txt";

	/**
	 * Starts a session of the game until user wants to stop
	 */
	public void startSession() {
		// Challenge: Flag for if user wants to keep playing
		boolean isUserStillPlaying = true;
		char userInput;
		// TODO: Erase duplicate by passing scanner instance by reference to Play()
		Scanner scanner = new Scanner(System.in);

		// Challenge: If save file exists, loads user play and win amount then displays it
		File saveFileRef = new File(this.saveFilePath);
		if(saveFileRef.exists()) {
			// Load
			try {
				FileInputStream fileInputStream = new FileInputStream(saveFileRef);
			    ObjectInputStream objectInputStream
			      = new ObjectInputStream(fileInputStream);
			    this.saveInstance = (SaveObject) objectInputStream.readObject();
			    fileInputStream.close();
			    objectInputStream.close();
			} catch (IOException|ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.saveInstance = new SaveObject();
			}
		}
		else {
			this.saveInstance = new SaveObject();
		}
		System.out.println(String.format("Total games: %d\nTotal wins: %d", this.saveInstance.getTotalGames(), this.saveInstance.getTotalWins()));
		
		// Challenge: Replay game
		System.out.println("Welcome! Do you want to play a game? (Y/N)");
		try {
			while (isUserStillPlaying) {

				userInput = scanner.nextLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'y':
					WordGuessingGame appInstance = new WordGuessingGame(this.wordList, 10);
					if(appInstance.Play()) {
						this.saveInstance.setTotalWins(this.saveInstance.getTotalWins() + 1);
					}
					this.saveInstance.setTotalGames(this.saveInstance.getTotalGames() + 1);
					System.out.println("Do you want to play another game? (Y/N)");
					break;
				case 'n':
					System.out.println("Goodbye!");
					isUserStillPlaying = false;
					break;
				default:
					System.out.println("Please enter \'Y\' or \'N\'");
				}

			}
		} catch (NoSuchElementException e) {
			System.out.println("Please enter 1 valid character!!");
		}
		// Challenge: Writes new user play and win amount, if no save file create new
		if (saveFileRef.exists()) {
			this.serializeSaveObject(saveFileRef, saveInstance);
		}
		else {
			// Create new
			try {
				saveFileRef.createNewFile();
				this.serializeSaveObject(saveFileRef, saveInstance);
			}
			catch(IOException e) {
				System.out.println("An error occurred when trying to create save file");
			}
		}

		
		scanner.close();
	}
	
	public void serializeSaveObject(File saveFileInstance, SaveObject saveInstace) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(saveFileInstance);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(saveInstace);
		    objectOutputStream.flush();
		    objectOutputStream.close();
		    fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
