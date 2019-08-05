package com.peter.weather.integrations.weather.openweather;

import com.peter.weather.integrations.weather.WeatherApiService;
import com.peter.weather.services.WeatherReportServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherApiServiceImpl implements WeatherApiService {

    private static String OPEN_WEATHER_API_DOMAIN = "http://api.openweathermap.org/data/2.5/weather";
    private static String OPEN_WEATHER_API_KEY = "APPID=cd6b889b8d572b9812cb62b95d913b67";
    private Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

    public OpenWeatherApiReport getWeatherForCity(String city){

        RestTemplate restTemplate = new RestTemplate();

        String apiUrl = buildApiUrl(city);

        if(apiUrl == null){

            return null;
        }

        OpenWeatherApiReport openWeatherApiReport = restTemplate.getForObject(apiUrl, OpenWeatherApiReport.class);

        return openWeatherApiReport;
    }


    private String buildApiUrl(String city){

        Integer cityId = null;

        try {
            cityId = OpenWeatherApiCity.valueOf(city).cityId;

        } catch (NullPointerException | IllegalArgumentException exception) {

            LOGGER.error("Unable to retrieve weather entry to populate 'description' : " + exception.getMessage());

            return null;

        }

        return OPEN_WEATHER_API_DOMAIN +
                "?id="+cityId+"&"+OPEN_WEATHER_API_KEY;
    }
}
