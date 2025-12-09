package shaunwassel.learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {
	public void listFiles(String directoryPath) {
		
		File directory = new File(directoryPath);
		if(directory.exists() && directory.isDirectory()) {
			File[] dirContents = directory.listFiles();
			
			if(dirContents != null && dirContents.length > 0) {
				for (File file : dirContents) {
					if (file.isDirectory()) {
						System.out.println(">> [DIR]: " + file.getName());
					}
					else {
						System.out.println("-- [FILE]: " + file.getName());
					}
				}
			}
			else {
				System.out.println("Directory is empty.");
			}
		}
		else {
			System.out.println("Path isn't a directory or doesn't exist.");
		}
		
	}
	
	public void createDirectory(String directoryPath) {
		
		File directory = new File(directoryPath);
		if(!directory.exists() ) {
			if(directory.mkdir()) {
				System.out.println("Directory created!");
			}
			else {
				System.out.println("Directory creation failed!");
			}
		}
		else {
			System.out.println("Directory path already exists, please rename!");
		}
		
	}
	public void deleteDirectoryOrFile(String directoryOrFilePath) {
		
		File directoryOrFile = new File(directoryOrFilePath);
		try {
			Files.delete(directoryOrFile.toPath()); // Can catch error messages
			System.out.println("Directory deleted!");
//			directoryOrFile.delete();
		} catch ( IOException e) {
			System.out.println("Directory can't be deleted: " + e.getMessage());
		}
		
	}
}
