package com.insurance.gateway.util;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private DateUtil() {}

    public static LocalDate createLocalDateFromIncomingParameter(@NonNull String dateAsString) {
        return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
