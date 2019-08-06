package com.peter.weather.services;

import com.peter.weather.integrations.weather.WeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.springframework.stereotype.Service;

@Service
public interface WeatherReportService {

    WeatherReport convertApiWeatherToWeatherReport(WeatherApiReport apiWeatherReport);

}
