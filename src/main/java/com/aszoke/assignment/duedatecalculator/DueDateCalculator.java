package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    LocalDateTime calculateDueDate(String creationDateTime, int turnaroundTimeInHours) {
        assertCreationDateTimeIsNotNull(creationDateTime);
        assertCreationDateTimeIsNotEmpty(creationDateTime);

        return null;
    }

    private void assertCreationDateTimeIsNotNull(String creationDateTime) {
        if (creationDateTime == null) {
            throw new IllegalArgumentException("creationDateTime must not be null!");
        }
    }

    private void assertCreationDateTimeIsNotEmpty(String creationDateTime) {
        if (creationDateTime.length() == 0) {
            throw new IllegalArgumentException("creationDateTime must not be empty!");
        }
    }
}
