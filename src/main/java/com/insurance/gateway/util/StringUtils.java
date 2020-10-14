package com.insurance.gateway.util;

public final class StringUtils {

    public static boolean checkIfStringIsNullOrEmpty(String stringToCheck) {
        return stringToCheck == null || stringToCheck.trim().isEmpty();
    }

}
