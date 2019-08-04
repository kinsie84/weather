package com.peter.weather.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@RestClientTest(DateTimeConversionService.class)
public class DateTimeConversionServiceTest {

    @Autowired
    private DateTimeConversionService dateTimeConversionService;


    @Test
    public void testGetTodaysDateByTimezone() {

        LocalDate expected = LocalDate.now(ZoneId.of("UTC+01:00"));
        LocalDate result = dateTimeConversionService.getTodaysDateByTimezone(3600);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetTodaysDateByTimezoneWithLargeOffsetThowsException() {

        try {
            dateTimeConversionService.getTodaysDateByTimezone(1800000);
        } catch(DateTimeException exception){
            return;
        }

       fail("Should have thrown a DateTimeException ");
    }

    @Test
    public void testGetTodaysDateByTimezoneWithNegativeOffset() {

        LocalDate expected = LocalDate.now(ZoneId.of("UTC-01:00"));
        LocalDate result = dateTimeConversionService.getTodaysDateByTimezone(-3600);

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testGetTodaysDateByTimezoneWithZeroOffset() {

        LocalDate result = dateTimeConversionService.getTodaysDateByTimezone(0);
        LocalDate expected = LocalDate.now(ZoneId.of("UTC+00:00"));

        Assert.assertEquals(expected,result);
    }


}
