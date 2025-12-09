package shaunwassel.learning;

public class FileApp implements UIEventHandler {
	
	FileManager app = null;
	
	public FileApp() {
		app = new FileManager();
	}

	public static void main(String[] args) {
		
		TextBasedInterface appInterface = new TextBasedInterface();
		appInterface.subscribe(new FileApp());
		appInterface.start();

	}

	@Override
	public void onDirectoryList(String directoryPath) {
		
		this.app.listFiles(directoryPath);
		
	}

	@Override
	public void onCreateDirectory(String directoryPath) {
		
		this.app.createDirectory(directoryPath);
		
	}

	@Override
	public void onDeleteDirectoryOrFile(String directoryOrFilePath) {
		
		this.app.deleteDirectoryOrFile(directoryOrFilePath);
		
	}

}
