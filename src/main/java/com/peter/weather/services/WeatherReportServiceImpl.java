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
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DateTimeConversionService dateTimeConversionService;
    @Autowired
    private TemperatureConversionService temperatureConversionService;
    private Logger LOGGER = LoggerFactory.getLogger(WeatherReportServiceImpl.class);

    @Override
    public WeatherReport convertApiWeatherToWeatherReport(WeatherApiReport apiWeatherReport) {

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCityName(apiWeatherReport.getCityName());
        weatherReport.setDescription(apiWeatherReport.getDescription());

        try {

            LocalDate today = dateTimeConversionService.getCurrentDateByTimezone(apiWeatherReport.getTimezone());
            weatherReport.setToday(today);
        } catch (NullPointerException | DateTimeException exception) {

            LOGGER.error("Unable to set today's date: " + exception.getMessage());
        }

        try {

            Double temperatureFahrenheit = temperatureConversionService.
                    convertKelvinTemperatureToFahrenheit(apiWeatherReport.getTemperature());
            weatherReport.setTemperatureFahrenheit(temperatureFahrenheit);
        } catch (Exception exception) {

            LOGGER.error("Unable to convert to temperature fahrenheit: " + exception.getMessage());
        }

        try {
            Double temperatureCelsius = temperatureConversionService.
                    convertKelvinTemperatureToCelsius(apiWeatherReport.getTemperature());
            weatherReport.setTemperatureCelsius(temperatureCelsius);
        } catch (Exception exception) {

            LOGGER.error("Unable  to convert to temperature celsius: " + exception.getMessage());
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        try {
            String sunsetTime = dateTimeConversionService.convertEpochToFormattedTime(apiWeatherReport.getSunsetTime(),
                    apiWeatherReport.getTimezone(), formatter);
            weatherReport.setSunsetTime(sunsetTime);
        } catch (Exception exception) {

            LOGGER.error("Unable to set sunset time: " + exception.getMessage());
        }

        try {
            String sunriseTime = dateTimeConversionService.convertEpochToFormattedTime(apiWeatherReport.getSunriseTime(),
                    apiWeatherReport.getTimezone(), formatter);
            weatherReport.setSunriseTime(sunriseTime);
        } catch (Exception exception) {

            LOGGER.error("Unable to set sunrise time: " + exception.getMessage());
        }

        return weatherReport;
    }

}
