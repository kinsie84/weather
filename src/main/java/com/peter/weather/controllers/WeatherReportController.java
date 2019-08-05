package com.peter.weather.controllers;

import com.peter.weather.integrations.weather.WeatherApiReport;
import com.peter.weather.integrations.weather.WeatherApiService;
import com.peter.weather.models.WeatherReport;
import com.peter.weather.services.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    WeatherApiService weatherApiService;

    @GetMapping("/{city}")
    public ModelAndView get(@PathVariable("city") String city) {

        WeatherApiReport apiWeatherReport = weatherApiService.getWeatherForCity(city);

        if (apiWeatherReport != null) {

            WeatherReport weatherReport = weatherReportService.convertApiWeatherToWeatherReport(apiWeatherReport);
            ModelAndView modelAndView = new ModelAndView("report");
            generateWeatherModel(modelAndView.getModelMap(), weatherReport);

            return modelAndView;

        } else {

            return new ModelAndView("error");
        }

    }

    private void generateWeatherModel(ModelMap modelMap, WeatherReport weatherReport){

        modelMap.addAttribute("city", weatherReport.getCityName()!=null ?
                weatherReport.getCityName(): "There was an issue retrieving the city name");
        modelMap.addAttribute("today", weatherReport.getToday() != null ?
                weatherReport.getToday() : "There was an issue retrieving today's date");
        modelMap.addAttribute("description", weatherReport.getDescription() != null ?
                weatherReport.getDescription() : "There was an issue retrieving the description");
        modelMap.addAttribute("fahrenheit", weatherReport.getTemperatureFahrenheit()!=null ?
                weatherReport.getTemperatureFahrenheit() + "°": "There was an issue receiving the fahrenheit temperature");
        modelMap.addAttribute("celsius", weatherReport.getTemperatureCelsius()!=null ?
                weatherReport.getTemperatureCelsius() + "°": "There was an issue receiving the celsius temperature");
        modelMap.addAttribute("sunrise", weatherReport.getSunriseTime()!=null ?
                weatherReport.getSunriseTime(): "There was an issue receiving the sunrise time");
        modelMap.addAttribute("sunset", weatherReport.getSunsetTime()!=null ?
                weatherReport.getSunsetTime(): "There was an issue receiving the sunset time");
    }
}
