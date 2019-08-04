package com.peter.weather.services;

import com.peter.weather.integrations.openweather.OpenWeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Autowired
    DateTimeConversionService dateTimeConversionService;
    @Autowired
    TemperatureConversionService temperatureConversionService;


    @Override
    public WeatherReport convertOpenWeatherToWeatherReport(OpenWeatherApiReport openWeatherApiReport) {

        WeatherReport weatherReport = new WeatherReport(openWeatherApiReport.getCityName(),
                openWeatherApiReport.getDescription());

        Double temperatureFahrenheit = temperatureConversionService.
                convertKelvinTemperatureToFahrenheit(openWeatherApiReport.getTemperatureKelvin());
        weatherReport.setTemperatureFahrenheit(temperatureFahrenheit);

        Double temperatureCelsius = temperatureConversionService.
                convertKelvinTemperatureToCelsius(openWeatherApiReport.getTemperatureKelvin());
        weatherReport.setTemperatureCelsius(temperatureCelsius);



        return weatherReport;
    }
}
