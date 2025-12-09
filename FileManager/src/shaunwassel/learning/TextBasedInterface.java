package shaunwassel.learning;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {

	// TEST: Change later to a list of handlers
	private UIEventHandler handlers = null;

	@Override
	public void start() {
		// TODO: Implement command generation in UIEventHandler
		while(true) {
			System.out.println("LIST OF COMMANDs PLACEHOLDER");
			
			System.out.println("Enter your choice: ");

			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			String path = "";
			scanner.nextLine(); // Consume leftover '\n'
			switch (choice) {
				case 1:
					System.out.println("Enter directory path to list: ");
					path = scanner.nextLine();
					this.handlers.onDirectoryList(path);
					break;
				case 2:
					System.out.println("Enter directory path to create: ");
					path = scanner.nextLine();
					this.handlers.onCreateDirectory(path);
					break;
				case 3:
					System.out.println("Enter directory path to delete: ");
					path = scanner.nextLine();
					this.handlers.onDeleteDirectoryOrFile(path);
					break;
				case 4:
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.out.println("Not a valid command!");
			}
		}

	}

	@Override
	public void subscribe(UIEventHandler eventHandler) {

		if (this.handlers == null) {
			this.handlers = eventHandler;
		}
	}

	@Override
	public void display(String message) {

		System.out.println(message);

	}

}
