package com.peter.weather.services;

import com.peter.weather.integrations.weather.ApiWeatherReport;
import com.peter.weather.integrations.weather.openweather.OpenWeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;


@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Autowired
    DateTimeConversionService dateTimeConversionService;
    @Autowired
    TemperatureConversionService temperatureConversionService;

    Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

    @Override
    public WeatherReport convertApiWeatherToWeatherReport(ApiWeatherReport apiWeatherReport) {

        WeatherReport weatherReport = new WeatherReport(apiWeatherReport.getCityName(),
                apiWeatherReport.getDescription());

        try {
            LocalDate today = dateTimeConversionService.getTodaysDateByTimezone(apiWeatherReport.getTimezone());
            weatherReport.setToday(today);

        } catch (DateTimeException exception) {
            LOGGER.error(exception.getMessage());
        }

        Double temperatureFahrenheit = temperatureConversionService.
                convertKelvinTemperatureToFahrenheit(apiWeatherReport.getTemperature());
        weatherReport.setTemperatureFahrenheit(temperatureFahrenheit);

        Double temperatureCelsius = temperatureConversionService.
                convertKelvinTemperatureToCelsius(apiWeatherReport.getTemperature());
        weatherReport.setTemperatureCelsius(temperatureCelsius);



        return weatherReport;
    }

}
