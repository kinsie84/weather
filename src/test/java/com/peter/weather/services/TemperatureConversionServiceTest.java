package com.peter.weather.services;

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

        Double expected = new Double(26.85);

        Double celsiusResult = temperatureConversionService.convertKelvinTemperatureToCelsius(300.0);

        Assert.assertEquals(expected,celsiusResult);

    }

    @Test
    public void testConvertKelvinToFahrenheit(){

        Double expected = new Double(8.33);

        Double fahrenheitResult = temperatureConversionService.convertKelvinTemperatureToFahrenheit(260.0);

        Assert.assertEquals(expected,fahrenheitResult);

    }
}
