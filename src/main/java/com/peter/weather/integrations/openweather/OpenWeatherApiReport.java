package com.peter.weather.integrations.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class OpenWeatherApiReport {

    private String cityName;
    private String description;
    private Double temperatureKelvin;
    private Long sunsetTime; //unix, UTC
    private Long sunriseTime; //unix, UTC
    private Long timezone; //Shift in seconds from UTC


    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        //TODO: handle cases where is out of bounds(catch index out of bounds exception)
        setDescription((String)weather.get("description"));
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperatureKelvin(Double.parseDouble(main.get("temp").toString()));
    }

    @JsonProperty("sys")
    public void setSys(Map<String, Object> sys) {
        setSunriseTime(Long.parseLong(sys.get("sunrise").toString()));
        setSunsetTime(Long.parseLong(sys.get("sunset").toString()));
    }

    @JsonSetter("timezone")
    public void setTimezone(Long time) {
        this.timezone = time;
    }

    public String getCityName() {
        return cityName;
    }

    @JsonSetter("name")
    public void setCityName(String name) {
        this.cityName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Double getTemperatureKelvin() {
        return this.temperatureKelvin;
    }

    public void setTemperatureKelvin(Double temperatureInKelvin) {
        this.temperatureKelvin = temperatureInKelvin;
    }

    public Long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(Long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public Long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(Long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public Long getTimezone() {
        return timezone;
    }
}
