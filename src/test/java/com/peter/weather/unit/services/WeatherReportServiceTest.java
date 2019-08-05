package com.peter.weather.unit.services;

import com.peter.weather.integrations.weather.WeatherApiReport;
import com.peter.weather.models.WeatherReport;
import com.peter.weather.services.DateTimeConversionService;
import com.peter.weather.services.TemperatureConversionService;
import com.peter.weather.services.WeatherReportService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@RestClientTest(WeatherReportService.class)
public class WeatherReportServiceTest {

    @Autowired
    private WeatherReportService weatherReportService;
    @MockBean
    private TemperatureConversionService temperatureConversionService;
    @MockBean
    private DateTimeConversionService dateTimeConversionService;

    @Test
    public void testConvertApiWeatherToWeatherReportThrowsNpe(){

        try {
            this.weatherReportService.convertApiWeatherToWeatherReport(null);
        }catch (NullPointerException exception){
            return;
        }
        fail("Should have thrown a null pointer exception");
    }


    @Test
    public void testConvertApiWeatherToWeatherReportDoesNotThowNpeIfObjectPropertiesNotSet(){

        WeatherApiReport weatherApiReport = new WeatherApiReport();
        WeatherReport report = null;
        try {
            report = this.weatherReportService.convertApiWeatherToWeatherReport(weatherApiReport);
        }catch (NullPointerException exception){

            fail("Should not have thrown a null pointer exception");
        }

        Assert.assertEquals(report.getToday(), null);
    }


}
