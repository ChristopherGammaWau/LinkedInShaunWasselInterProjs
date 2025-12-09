package shaunwassel.learning;

import java.util.Scanner;

public class WeatherApp {

	public static void main(String[] args) {
		// User input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter city: ");
		
		WeatherAPI api = new WeatherAPI();
		String response = api.getForecast(scanner.nextLine());
		

		
		WeatherResponseParser responseParser = new WeatherResponseParser();
		responseParser.parseAndPrint(response);
	}

}
