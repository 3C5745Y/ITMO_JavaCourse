package ru.weatherbot.weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherUtils {

    public final static Map<String, String> weatherIconsCodes = new HashMap<>();

    static {
        weatherIconsCodes.put("Clear", "☀️");
        weatherIconsCodes.put("Rain", "🌧");
        weatherIconsCodes.put("Snow", "❄️");
        weatherIconsCodes.put("Clouds", "☁️");
    }

}
