package com.peter.weather.services;

import org.springframework.stereotype.Service;

@Service
public interface TemperatureConversionService {

    Double convertKelvinTemperatureToCelsius(Double temperatureKelvin);

    Double convertKelvinTemperatureToFahrenheit(Double temperatureKelvin);

}
