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
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@RestClientTest(DateTimeConversionService.class)
public class DateTimeConversionServiceTest {

    @Autowired
    private DateTimeConversionService dateTimeConversionService;


    @Test
    public void testGetCurrentDateByTimezone() {

        LocalDate expected = LocalDate.now(ZoneId.of("UTC+08:00"));
        LocalDate result = dateTimeConversionService.getCurrentDateByTimezone(28800);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCurrentDateByTimezoneWithLargeOffsetThrowsException() {

        try {
            dateTimeConversionService.getCurrentDateByTimezone(1800000);
        } catch (DateTimeException exception) {
            return;
        }

        fail("Should have thrown a DateTimeException ");
    }

    @Test
    public void testGetCurrentDateByTimezoneWithNegativeOffset() {

        LocalDate expected = LocalDate.now(ZoneId.of("UTC-08:00"));
        LocalDate result = dateTimeConversionService.getCurrentDateByTimezone(-28800);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testGetCurrentDateByTimezoneWithZeroOffset() {

        LocalDate expected = LocalDate.now(ZoneId.of("UTC+00:00"));
        LocalDate result = dateTimeConversionService.getCurrentDateByTimezone(0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testConvertUnixTimestampToFormattedTime() {

        String expected = "05:29 AM";
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("hh:mm a");
        String result = dateTimeConversionService.convertEpochToFormattedTime(1564979383, 3600, formatter);

        Assert.assertEquals(expected, result);

    }


}
