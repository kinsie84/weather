package com.peter.weather.services;

import com.peter.weather.integrations.openweather.OpenWeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.springframework.stereotype.Service;

@Service
public interface WeatherReportService {

    WeatherReport convertOpenWeatherToWeatherReport(OpenWeatherApiReport openWeatherApiReport);
}
