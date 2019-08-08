package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    private static final int WORKDAY_LENGTH_IN_HOURS = 8;

    LocalDateTime calculateDueDate(LocalDateTime creationDateTime, int turnaroundTimeInHours) {
        int workDays = getWorkDays(turnaroundTimeInHours);
        int hoursInPartialWorkday = getHoursInPartialWorkDay(turnaroundTimeInHours);

        LocalDateTime dueDateTime = creationDateTime.plusDays(workDays);
        return dueDateTime.plusHours(hoursInPartialWorkday);
    }

    private int getWorkDays(int totalHours) {
        return totalHours / WORKDAY_LENGTH_IN_HOURS;
    }

    private int getHoursInPartialWorkDay(int totalHours) {
        return totalHours % WORKDAY_LENGTH_IN_HOURS;
    }
}
