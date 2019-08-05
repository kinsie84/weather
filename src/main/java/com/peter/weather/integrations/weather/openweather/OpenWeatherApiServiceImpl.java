package com.peter.weather.integrations.weather.openweather;
import com.peter.weather.integrations.weather.WeatherApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherApiServiceImpl implements WeatherApiService {

    public OpenWeatherApiReport getWeatherForCity(String city){

        Integer cityId = OpenWeatherApiCity.valueOf(city).cityId;

        RestTemplate restTemplate = new RestTemplate();

        // TODO Method to build URL
        OpenWeatherApiReport openWeatherApiReport = restTemplate.getForObject(OpenWeatherApiConstants.OPEN_WEATHER_API_DOMAIN +
                "?id="+cityId+"&"+OpenWeatherApiConstants.OPEN_WEATHER_API_KEY, OpenWeatherApiReport.class);
        return openWeatherApiReport;
    }
}
