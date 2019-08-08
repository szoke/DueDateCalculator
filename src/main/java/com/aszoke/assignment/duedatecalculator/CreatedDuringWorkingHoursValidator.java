package com.aszoke.assignment.duedatecalculator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

class CreatedDuringWorkingHoursValidator {

    private static final DayOfWeek[] WORKDAYS = {
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
    };

    private static final LocalTime WORKING_HOURS_START = LocalTime.of(9, 0);
    private static final LocalTime WORKING_HOURS_END = LocalTime.of(17, 0);

    void validate(LocalDateTime creationDateTime) {
        assertCreatedOnWorkday(creationDateTime);
        assertCreatedDuringWorkingHours(creationDateTime);
    }

    private void assertCreatedOnWorkday(LocalDateTime creationDateTime) {
        if (Arrays.stream(WORKDAYS).noneMatch(workDay -> workDay.equals(creationDateTime.getDayOfWeek()))) {
            throw new IllegalArgumentException("Bug must be created on a workday!");
        }
    }

    private void assertCreatedDuringWorkingHours(LocalDateTime creationDateTime) {
        if (creationDateTime.toLocalTime().isBefore(WORKING_HOURS_START) ||
                creationDateTime.toLocalTime().isAfter(WORKING_HOURS_END)) {
            throw new IllegalArgumentException("Bug must be created during working hours!");
        }
    }
}
