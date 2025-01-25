package io.testomat.e2e_tests_light_1.utils;

import org.jetbrains.annotations.NotNull;

public class StringParsers {

    @NotNull
    public static Integer parseIntegerFromString(String targetText) {
        String digitText = targetText.replaceAll("\\D+", "");

        return Integer.parseInt(digitText);
        // is designed to extract all numeric digits from a given string and convert them into an Integer
    }

    public static Double parseDoubleFromString(String targetText) {
        String doubleText = targetText.replaceAll("[^\\d.]", ""); // keeps only digits and decimal
        return Double.parseDouble(doubleText);
        // is designed to extract numeric values (including decimals) from a string and convert them into a Double

    }
}
