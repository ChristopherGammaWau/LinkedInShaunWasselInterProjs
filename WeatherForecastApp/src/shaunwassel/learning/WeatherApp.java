package shaunwassel.learning;

public class WeatherApp {

	public static void main(String[] args) {
		WeatherAPI api = new WeatherAPI();
		String response = api.getForecast("Detroit");
		System.out.println(response);
	}

}
