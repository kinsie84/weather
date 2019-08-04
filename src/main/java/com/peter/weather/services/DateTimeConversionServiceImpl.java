package com.peter.weather.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

@Service
public class DateTimeConversionServiceImpl implements DateTimeConversionService {

    public LocalDate getTodaysDateByTimezone(long secondsOffset) throws DateTimeException {
        if (secondsOffset == 0) {
            return LocalDate.now(ZoneId.of("UTC+00:00"));
        }

        Long hours = TimeUnit.SECONDS.toHours(secondsOffset);
        Long minutes = TimeUnit.SECONDS.toMinutes(secondsOffset);
        minutes = minutes - TimeUnit.HOURS.toMinutes(hours);
        Long secondsRemaining = secondsOffset - TimeUnit.MINUTES.toSeconds(minutes)
                - TimeUnit.HOURS.toSeconds(hours);

        return LocalDate.now(ZoneId.ofOffset("UTC",
                    ZoneOffset.ofHoursMinutesSeconds(hours.intValue(), minutes.intValue(), secondsRemaining.intValue())));

    }
}
