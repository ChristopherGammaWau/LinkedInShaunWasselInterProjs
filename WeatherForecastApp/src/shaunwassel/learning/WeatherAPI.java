package shaunwassel.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import io.github.cdimascio.dotenv.Dotenv;

public class WeatherAPI {
	
	private final String API_KEY;
	private final String API_URL;
	
	public WeatherAPI() {
		
		Dotenv dotenv = Dotenv.load();
		API_KEY = dotenv.get("API_KEY");
		API_URL = dotenv.get("API_URL");
		
	}
	
	public String getForecast(String city) {
		String apiUrl = "";
		try {
			apiUrl = API_URL + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8.toString()) + "&appid=" + API_KEY + "&units=metric";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			URL url = new URL(apiUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			
			while((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			return response.toString();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
