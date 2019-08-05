package com.peter.weather.services;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Service
public class DateTimeConversionServiceImpl implements DateTimeConversionService {

    public LocalDate getCurrentDateByTimezone(long secondsOffset) {

        if (secondsOffset == 0) {

            return LocalDate.now(ZoneId.of("UTC+00:00"));
        }

        ZoneId zoneId = getZoneIdBySecondsOffset(secondsOffset);

        return LocalDate.now(zoneId);

    }

    public String convertEpochToFormattedTime(long unixTime, long secondsOffset, DateTimeFormatter dateTimeFormatter) {

        ZoneId zoneId = getZoneIdBySecondsOffset(secondsOffset);

        return Instant.ofEpochSecond(unixTime).atZone(zoneId).format(dateTimeFormatter);

    }

    private ZoneId getZoneIdBySecondsOffset(long secondsOffset) {

        Long hours = TimeUnit.SECONDS.toHours(secondsOffset);

        Long minutes = TimeUnit.SECONDS.toMinutes(secondsOffset);

        minutes = minutes - TimeUnit.HOURS.toMinutes(hours);

        Long secondsRemaining = secondsOffset - TimeUnit.MINUTES.toSeconds(minutes)
                - TimeUnit.HOURS.toSeconds(hours);

        return ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutesSeconds(hours.intValue(),
                minutes.intValue(), secondsRemaining.intValue()));

    }
}
