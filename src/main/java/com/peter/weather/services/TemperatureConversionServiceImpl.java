package com.peter.weather.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TemperatureConversionServiceImpl implements TemperatureConversionService{


    @Override
    public Double convertKelvinTemperatureToCelsius(Double temperatureKelvin) {

        Double conversionFormula = temperatureKelvin - 273.15;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(conversionFormula));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }

    @Override
    public Double convertKelvinTemperatureToFahrenheit(Double temperatureKelvin) {

        Double conversionFormula = temperatureKelvin * (9.0/5.0) - 459.67;
        BigDecimal bigDecimal = new BigDecimal(Double.toString(conversionFormula));
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);

        return bigDecimal.doubleValue();
    }
}
