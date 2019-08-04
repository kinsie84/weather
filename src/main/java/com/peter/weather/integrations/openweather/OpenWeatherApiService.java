package com.peter.weather.integrations.openweather;

import org.springframework.stereotype.Service;

@Service
public interface OpenWeatherApiService {

    OpenWeatherApiReport getWeatherForCity(String city);

}