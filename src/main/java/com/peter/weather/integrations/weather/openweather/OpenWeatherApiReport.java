package com.peter.weather.integrations.weather.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.peter.weather.integrations.weather.ApiWeatherReport;

import java.util.List;
import java.util.Map;

public class OpenWeatherApiReport extends ApiWeatherReport {


    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        Map<String, Object> weather = weatherEntries.get(0);
        //TODO: handle cases where is out of bounds(catch index out of bounds exception)
        setDescription((String) weather.get("description"));
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperature(Double.parseDouble(main.get("temp").toString()));
    }

    @JsonProperty("sys")
    public void setSys(Map<String, Object> sys) {
        setSunriseTime(Long.parseLong(sys.get("sunrise").toString()));
        setSunsetTime(Long.parseLong(sys.get("sunset").toString()));
    }

    @JsonSetter("timezone")
    public void setTimezoneFromJson(Long time) {
        this.setTimezone(time);
    }


    @JsonSetter("name")
    public void setCityNameFromJson(String name) {
        this.setCityName(name);
    }

}

