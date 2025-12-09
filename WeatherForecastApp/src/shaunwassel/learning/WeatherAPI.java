package shaunwassel.learning;

import io.github.cdimascio.dotenv.Dotenv;

public class WeatherAPI {
	
	private final String API_KEY;
	
	public WeatherAPI() {
		
		Dotenv dotenv = Dotenv.load();
		API_KEY = dotenv.get("API_KEY");
		
	}
	
	public static void main(String[] args) {
	}

}
