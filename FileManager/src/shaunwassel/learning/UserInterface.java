package shaunwassel.learning;

public interface UserInterface {
	public void start();
	public void subscribe(UIEventHandler eventHandler);
	public void display(String message);
}
