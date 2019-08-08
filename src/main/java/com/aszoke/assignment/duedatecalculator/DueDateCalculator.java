package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    LocalDateTime calculateDueDate(String creationDateTime, int turnaroundTimeInHours) {
        assertLocalDateTimeNotNullNotEmpty(creationDateTime);
        assertNonNegative(turnaroundTimeInHours);

        parseLocalDateTime(creationDateTime);

        return null;
    }

    private void assertLocalDateTimeNotNullNotEmpty(String localDateTime) {
        assertLocalDateTimeIsNotNull(localDateTime);
        assertCreationDateTimeIsNotEmpty(localDateTime);
    }

    private void assertLocalDateTimeIsNotNull(String localDateTime) {
        if (localDateTime == null) {
            throw new IllegalArgumentException("localDateTime must not be null!");
        }
    }

    private void assertCreationDateTimeIsNotEmpty(String localDateTime) {
        if (localDateTime.length() == 0) {
            throw new IllegalArgumentException("localDateTime must not be empty!");
        }
    }

    private void assertNonNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be greater or equal to 0.");
        }
    }

    private LocalDateTime parseLocalDateTime(String localDateTime) {
        return LocalDateTime.parse(localDateTime);
    }
}
