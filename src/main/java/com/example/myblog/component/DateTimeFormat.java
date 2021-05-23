package com.example.myblog.component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeFormat {
    public static Long toInstant(){
        return ZonedDateTime.now(ZoneId.of("America/New_York")).toEpochSecond();
    }
    public static LocalDateTime toLocalDateTime(Long time){
        return Instant.ofEpochSecond(time).atZone(ZoneId.of("America/New_York")).toLocalDateTime();
    }
}
