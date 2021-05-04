package ru.weatherbot.weather;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    private static String LINK = "https://api.openweathermap.org/data/2.5/onecall?lat=%s&lon=%s&lang=ru&appid=%s&exclude=alerts,minutely,hourly";
    private static String KEY = "58c54753f406bee9b29690cf1feac8d2";

    private static String kelvinToCelsius(double input) {
        return Math.round(input - 273.15) + "°C";
    }

    public static String getWeather(double lat, double lon) throws IOException {

        String urlString = String.format(LINK, lat, lon, KEY);
        URL urlObject = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new IllegalArgumentException();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String data = response.toString();

        return getParseWeather(data);
    }
    public static String getParseWeather(String jsonString) throws IOException {
        JSONObject object = new JSONObject(jsonString);
        String currentDes = object.getJSONObject("current").getJSONArray("weather").getJSONObject(0).getString("description");
        double currentTemp = object.getJSONObject("current").getDouble("temp");
        double currentFeelsLike = object.getJSONObject("current").getDouble("feels_like");
        double currentWindSpeed = Math.round(object.getJSONObject("current").getDouble("wind_speed"));

        String nextDayDes = object.getJSONArray("daily").getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("description");
        double nextDayTemp = object.getJSONArray("daily").getJSONObject(1).getJSONObject("temp").getDouble("day");
        double nextDayFeelsLike = object.getJSONArray("daily").getJSONObject(1).getJSONObject("feels_like").getDouble("day");
        double nextDayWindSpeed = object.getJSONArray("daily").getJSONObject(1).getDouble("wind_speed");

        String data = "Прогноз на сегодня: " + currentDes + "\n" +
                "Темп.воздуха: " + kelvinToCelsius(currentTemp) + "\n" +
                "Ощущается как: " + kelvinToCelsius(currentFeelsLike) + "\n" +
                "Скорость ветра: " + currentWindSpeed + " м/с\n\n" +
                "Прогноз на ближайшие сутки:\n" +
                nextDayDes + "\n" +
                "Темп.воздуха: " + kelvinToCelsius(nextDayTemp) + "\n" +
                "Ощущается как: " + kelvinToCelsius(nextDayFeelsLike) + "\n" +
                "Скорость ветра: " + nextDayWindSpeed + " м/с\n";

        return data;
    }

}
