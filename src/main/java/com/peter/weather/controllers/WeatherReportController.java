package com.peter.weather.controllers;

import com.peter.weather.integrations.openweather.OpenWeatherApiCity;
import com.peter.weather.integrations.openweather.OpenWeatherApiService;
import com.peter.weather.models.WeatherReport;
import com.peter.weather.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/weather")
public class WeatherReportController {

    @Autowired
    WeatherReportService weatherReportService;
    @Autowired
    OpenWeatherApiService openWeatherApiService;

    @GetMapping("/{city}")
    public ModelAndView get(@PathVariable("city") String city) {

        int cityId = OpenWeatherApiCity.valueOf(city).cityId;


        return new ModelAndView("report");
    }
}
