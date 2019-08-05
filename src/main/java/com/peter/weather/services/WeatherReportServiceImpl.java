package com.peter.weather.services;

import com.peter.weather.integrations.weather.WeatherApiReport;
import com.peter.weather.models.WeatherReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Autowired
    DateTimeConversionService dateTimeConversionService;
    @Autowired
    TemperatureConversionService temperatureConversionService;

    private Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

    @Override
    public WeatherReport convertApiWeatherToWeatherReport(WeatherApiReport apiWeatherReport) {

        WeatherReport weatherReport = new WeatherReport(apiWeatherReport.getCityName(),
                apiWeatherReport.getDescription());

        try {
            LocalDate today = dateTimeConversionService.getCurrentDateByTimezone(apiWeatherReport.getTimezone());
            weatherReport.setToday(today);
        } catch (DateTimeException exception) {
            LOGGER.error("Unable to set today's date: " + exception.getMessage());
        }

        Double temperatureFahrenheit = temperatureConversionService.
                convertKelvinTemperatureToFahrenheit(apiWeatherReport.getTemperature());
        weatherReport.setTemperatureFahrenheit(temperatureFahrenheit);

        Double temperatureCelsius = temperatureConversionService.
                convertKelvinTemperatureToCelsius(apiWeatherReport.getTemperature());
        weatherReport.setTemperatureCelsius(temperatureCelsius);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        String sunsetTime = dateTimeConversionService.convertEpochToFormattedTime(apiWeatherReport.getSunsetTime(),
                apiWeatherReport.getTimezone(), formatter);
        weatherReport.setSunsetTime(sunsetTime);

        String sunriseTime = dateTimeConversionService.convertEpochToFormattedTime(apiWeatherReport.getSunriseTime(),
                apiWeatherReport.getTimezone(), formatter);
        weatherReport.setSunriseTime(sunriseTime);


        return weatherReport;
    }

}
