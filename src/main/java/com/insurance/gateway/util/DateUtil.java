package com.insurance.gateway.util;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private DateUtil() {}

    public static LocalDateTime createLocalDateTimeFromUTCString(@NonNull String dateInUtcFormat) {
        return LocalDateTime.parse(dateInUtcFormat, DateTimeFormatter.ISO_INSTANT); // ISO_INSTANT - 2011-12-03T10:15:30Z
    }

}
