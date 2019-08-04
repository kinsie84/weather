package com.peter.weather.integrations.openweather;


@Service
public interface OpenWeatherApiService {

    OpenWeatherApiReport getWeatherForCity(String city);

}