package com.aszoke.assignment.duedatecalculator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

class DueDateCalculator {

    private static final int WORKDAY_LENGTH_IN_HOURS = 8;

    LocalDateTime calculateDueDate(LocalDateTime creationDateTime, int turnaroundTimeInHours) {
        int workDays = getWorkDays(turnaroundTimeInHours);
        int hoursInPartialWorkday = getHoursInPartialWorkDay(turnaroundTimeInHours);

        LocalDateTime dueDateTime = creationDateTime;
        while (workDays > 0) {
            dueDateTime = getNextWorkDay(dueDateTime);
            workDays--;
        }

        return dueDateTime.plusHours(hoursInPartialWorkday);
    }

    private LocalDateTime getNextWorkDay(LocalDateTime localDateTime) {
        if (localDateTime.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
            return localDateTime.plusDays(3L);
        } else if (localDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            return localDateTime.plusDays(2L);
        } else {
            return localDateTime.plusDays(1L);
        }
    }

    private int getWorkDays(int totalHours) {
        return totalHours / WORKDAY_LENGTH_IN_HOURS;
    }

    private int getHoursInPartialWorkDay(int totalHours) {
        return totalHours % WORKDAY_LENGTH_IN_HOURS;
    }
}
