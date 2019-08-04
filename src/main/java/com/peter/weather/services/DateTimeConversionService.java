package com.peter.weather.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface DateTimeConversionService {


    LocalDate getTodaysDateByTimezone(long secondsOffset);


}
