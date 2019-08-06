package com.peter.weather.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public interface DateTimeConversionService {

    LocalDate getCurrentDateByTimezone(long secondsOffset);

    String convertEpochToFormattedTime(long unixTime, long secondsOffset, DateTimeFormatter dateTimeFormatter);

}
