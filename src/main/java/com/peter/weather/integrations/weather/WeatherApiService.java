package com.peter.weather.integrations.weather;

import org.springframework.stereotype.Service;

@Service
public interface WeatherApiService {

    WeatherApiReport getWeatherForCity(String city);

}