package shaunwassel.learning;

public interface UIEventHandler {
	public void onDirectoryList(String directoryPath);
	public void onCreateDirectory(String directoryPath);
	public void onDeleteDirectoryOrFile(String directoryOrFilePath);
}
