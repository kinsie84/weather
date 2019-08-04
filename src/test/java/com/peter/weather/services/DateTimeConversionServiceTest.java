package com.peter.weather.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@RestClientTest(DateTimeConversionService.class)
public class DateTimeConversionServiceTest {

    @Autowired
    private DateTimeConversionService dateTimeConversionService;


}
