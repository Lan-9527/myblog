package com.example.myblog.component;

import java.time.*;

public class DateTimeFormat {
    private static LocalTime workShift = LocalTime.of(8,0,0);
    private static LocalTime closingTime = LocalTime.of(18,0,0);
    private static final ZoneId zoneId = ZoneId.of("Asia/Shanghai");
    /**
     * 当前时间戳
     * @return
     */
    public static Long toInstant(){
        return ZonedDateTime.now(zoneId).toEpochSecond();
    }

    /**
     * 时间戳转为本地时间
     * @param time
     * @return
     */
    public static LocalDateTime toLocalDateTime(Long time){
        return Instant.ofEpochSecond(time).atZone(zoneId).toLocalDateTime();
    }

    /**
     * 本地时间转为时间戳
     * 如果为空 则为今天最小的时间
     * @param localDateTime
     * @return
     */
    public static  Long toInstant(LocalDateTime localDateTime){
        if (localDateTime == null) return LocalDateTime.of(LocalDate.now(), LocalTime.MIN).atZone(zoneId).toEpochSecond();
        return localDateTime.atZone(zoneId).toEpochSecond();
    }

    public static LocalTime getWorkShift() {
        return workShift;
    }

    public static void setWorkShift(LocalTime workShift) {
        DateTimeFormat.workShift = workShift;
    }

    public static LocalTime getClosingTime() {
        return closingTime;
    }

    public static void setClosingTime(LocalTime closingTime) {
        DateTimeFormat.closingTime = closingTime;
    }
}
