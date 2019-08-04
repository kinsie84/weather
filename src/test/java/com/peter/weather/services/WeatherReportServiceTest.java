package com.peter.weather.services;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@RestClientTest(WeatherReportService.class)
public class WeatherReportServiceTest {

    @Autowired
    private WeatherReportService weatherReportService;


}
