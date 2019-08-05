package com.peter.weather.integrations.weather.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.peter.weather.integrations.weather.WeatherApiReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class OpenWeatherApiReport extends WeatherApiReport {

    Logger LOGGER = LoggerFactory.getLogger(OpenWeatherApiReport.class);

    @JsonProperty("weather")
    public void setWeather(List<Map<String, Object>> weatherEntries) {
        try{
        Map<String, Object> weather = weatherEntries.get(0);
        setDescription((String) weather.get("description"));

        }catch(IndexOutOfBoundsException exception){
            LOGGER.error("Unable to retrieve weather entry to populate 'description' : " + exception.getMessage());
        }
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

