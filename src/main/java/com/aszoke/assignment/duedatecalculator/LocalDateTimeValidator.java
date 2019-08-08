package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class LocalDateTimeValidator {

    void validate(String localDateTime) {
        assertLocalDateTimeIsNotNull(localDateTime);
        assertLocalDateTimeIsNotEmpty(localDateTime);
        assertLocalDateTimeCanBeParsed(localDateTime);
    }

    private void assertLocalDateTimeIsNotNull(String localDateTime) {
        if (localDateTime == null) {
            throw new IllegalArgumentException("localDateTime must not be null!");
        }
    }

    private void assertLocalDateTimeIsNotEmpty(String localDateTime) {
        if (localDateTime.length() == 0) {
            throw new IllegalArgumentException("localDateTime must not be empty!");
        }
    }

    private void assertLocalDateTimeCanBeParsed(String localDateTime) {
        LocalDateTime.parse(localDateTime);
    }
}
