package com.peter.weather.integrations.weather.openweather;
;
import com.peter.weather.integrations.weather.WeatherApiService;
import com.peter.weather.services.DateTimeConversionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherApiServiceImpl implements WeatherApiService {

    Logger logger = LoggerFactory.getLogger(OpenWeatherApiServiceImpl.class);

    public OpenWeatherApiReport getWeatherForCity(String city){


        // TODO: method to get cityId from String
        Integer cityId = OpenWeatherApiCity.valueOf(city).cityId;

        //

        RestTemplate restTemplate = new RestTemplate();

        // TODO Method to build URL
        OpenWeatherApiReport openWeatherApiReport = restTemplate.getForObject(OpenWeatherApiConstants.OPEN_WEATHER_API_DOMAIN +
                "?id="+cityId+"&"+OpenWeatherApiConstants.OPEN_WEATHER_API_KEY, OpenWeatherApiReport.class);
        return openWeatherApiReport;
    }
}
