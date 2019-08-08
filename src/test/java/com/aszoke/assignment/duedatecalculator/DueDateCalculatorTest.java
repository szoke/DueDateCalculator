package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class DueDateCalculatorTest {

    private static final int TURNAROUND_TIME_ZERO = 0;
    private static final int TURNAROUND_TIME_ONE_HOUR = 1;

    private static final LocalTime WORK_START = LocalTime.of(9, 0, 0);
    private static final LocalDate MONDAY = LocalDate.of(2019, 8, 5);
    private static final LocalDateTime MONDAY_WORK_START = LocalDateTime.of(MONDAY, WORK_START);

    private static final LocalDateTime EXPECTED_DUE_DATE_MONDAY_WORK_START_ZERO_TURNAROUND =
            MONDAY_WORK_START;
    private static final LocalDateTime EXPECTED_DUE_DATE_MONDAY_WORK_START_ONE_HOUR_TURNAROUND =
            MONDAY_WORK_START.plusHours(1L);

    private final DueDateCalculator underTest = new DueDateCalculator();

    @Test
    public void testCalculateDueDateShouldReturnCreationDateWhenTurnAroundTimeIsZero() {
        LocalDateTime actual = underTest.calculateDueDate(MONDAY_WORK_START, TURNAROUND_TIME_ZERO);

        assertEquals(EXPECTED_DUE_DATE_MONDAY_WORK_START_ZERO_TURNAROUND, actual);
    }

    @Test
    public void testCalculateDueDateShouldReturnCreationDateTimePlusOneHourWhenTurnaroundTimeIsOneHour() {
        LocalDateTime actual = underTest.calculateDueDate(MONDAY_WORK_START, TURNAROUND_TIME_ONE_HOUR);

        assertEquals(EXPECTED_DUE_DATE_MONDAY_WORK_START_ONE_HOUR_TURNAROUND, actual);
    }
}