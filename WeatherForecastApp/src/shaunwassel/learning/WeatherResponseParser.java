package shaunwassel.learning;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherResponseParser {
	
	public void parseAndPrint(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		
		// Response code
		if (jsonObject.getInt("cod") == 200) {
			System.out.println("Weather forecast for city: ");
			JSONArray forecasts = jsonObject.getJSONArray("list");
			for(int i = 0; i < forecasts.length(); i++) {
				JSONObject forecast = forecasts.getJSONObject(i);
				long timestamp = forecast.getLong("dt");
				String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date(timestamp * 1000));
				double temperature = forecast.getJSONObject("main").getDouble("temp");
				int humidity = forecast.getJSONObject("main").getInt("humidity");
				String description = forecast.getJSONArray("weather").getJSONObject(0).getString("description");
				
				System.out.println(date + ": " + temperature + "C, Humidity: " + humidity + "%, " + description);
			}
		} 
		else {
			System.out.println("Error making request!");
		}
	}

}
