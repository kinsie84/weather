package com.peter.weather.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class WeatherReport {

    public LocalDate today;
    public String cityName;
    public String description;
    public Double temperatureFahrenheit;
    public Double temperatureCelsius;
    public LocalTime sunriseTime;
    public LocalTime sunsetTime;

    public WeatherReport(String cityName, String description){
        this.cityName = cityName;
        this.description = description;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }

    public void setTemperatureFahrenheit(Double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public Double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(Double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

}
