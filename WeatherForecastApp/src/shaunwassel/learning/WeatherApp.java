package shaunwassel.learning;

public class WeatherApp {

	public static void main(String[] args) {
		WeatherAPI api = new WeatherAPI();
		String response = api.getForecast("Detroit");
		
		WeatherResponseParser responseParser = new WeatherResponseParser();
		responseParser.parseAndPrint(response);
	}

}
