package com.peter.weather.integrations.weather;

import org.springframework.stereotype.Service;

@Service
public interface WeatherApiService {

    ApiWeatherReport getWeatherForCity(String city);

}