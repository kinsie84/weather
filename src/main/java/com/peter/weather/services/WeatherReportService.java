package com.peter.weather.services;

import com.peter.weather.integrations.weather.ApiWeatherReport;
import com.peter.weather.integrations.weather.openweather.OpenWeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.springframework.stereotype.Service;

@Service
public interface WeatherReportService {

    WeatherReport convertApiWeatherToWeatherReport(ApiWeatherReport apiWeatherReport);
}
