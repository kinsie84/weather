package com.peter.weather.controllers;

import com.peter.weather.integrations.weather.ApiWeatherReport;
import com.peter.weather.integrations.weather.openweather.OpenWeatherApiReport;
import com.peter.weather.integrations.weather.WeatherApiService;
import com.peter.weather.integrations.weather.openweather.OpenWeatherApiServiceImpl;
import com.peter.weather.models.WeatherReport;
import com.peter.weather.services.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    WeatherApiService weatherApiService;
    Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @GetMapping("/{city}")
    public ModelAndView get(@PathVariable("city") String city) {


        ApiWeatherReport apiWeatherReport = weatherApiService.getWeatherForCity(city);
        WeatherReport weatherReport = weatherReportService.convertApiWeatherToWeatherReport(apiWeatherReport);

        ModelAndView modelAndView = new ModelAndView("report");
        modelAndView.getModelMap().addAttribute("city",weatherReport.getCityName());
        modelAndView.getModelMap().addAttribute("today",weatherReport.getToday()!=null?weatherReport.getToday():"There was an issue retrieving today's date");
        modelAndView.getModelMap().addAttribute("description",weatherReport.getDescription());
        modelAndView.getModelMap().addAttribute("fahrenheit",weatherReport.getTemperatureFahrenheit() + "°") ;
        modelAndView.getModelMap().addAttribute("celsius",weatherReport.getTemperatureCelsius()+ "°");

        return modelAndView;
    }
}
