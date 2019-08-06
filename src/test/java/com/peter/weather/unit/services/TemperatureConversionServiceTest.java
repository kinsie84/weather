package com.peter.weather.unit.services;

import com.peter.weather.services.TemperatureConversionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@RestClientTest(TemperatureConversionService.class)
public class TemperatureConversionServiceTest {


    @Autowired
    private TemperatureConversionService temperatureConversionService;

    @Test
    public void testConvertKelvinToCelsius(){

        Double expected = 26.85;

        Double celsiusResult = temperatureConversionService.convertKelvinTemperatureToCelsius(300.0);

        Assert.assertEquals(expected,celsiusResult);

    }

    @Test
    public void testConvertKelvinAtZeroToCelsius(){

        Double expected = -273.15;

        Double celsiusResult = temperatureConversionService.convertKelvinTemperatureToCelsius(0.00);

        Assert.assertEquals(expected,celsiusResult);

    }

    @Test
    public void testConvertKelvinToFahrenheit(){

        Double expected = 8.33;

        Double fahrenheitResult = temperatureConversionService.convertKelvinTemperatureToFahrenheit(260.0);

        Assert.assertEquals(expected,fahrenheitResult);

    }

    @Test
    public void testConvertKelvinAtZeroToFahrenheit(){

        Double expected = -459.67;

        Double celsiusResult = temperatureConversionService.convertKelvinTemperatureToFahrenheit(0.00);

        Assert.assertEquals(expected,celsiusResult);

    }

}
