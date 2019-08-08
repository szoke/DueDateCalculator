package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class DueDateCalculatorTest {

    private static final int TURNAROUND_TIME_ZERO = 0;
    private static final int TURNAROUND_TIME_ONE_HOUR = 1;
    private static final int TURNAROUND_TIME_ENTIRE_WORKDAY = 8;

    private static final LocalTime WORK_START = LocalTime.of(9, 0, 0);
    private static final LocalTime WORK_END = LocalTime.of(17, 0, 0);

    private static final LocalDate MONDAY = LocalDate.of(2019, 8, 5);
    private static final LocalDateTime MONDAY_WORK_START = LocalDateTime.of(MONDAY, WORK_START);
    private static final LocalDateTime MONDAY_WORK_END = LocalDateTime.of(MONDAY, WORK_END);

    private static final LocalDate TUESDAY = MONDAY.plusDays(1L);
    private static final LocalDateTime TUESDAY_WORK_START = LocalDateTime.of(TUESDAY, WORK_START);

    private static final LocalDateTime EXPECTED_DUE_DATE_MONDAY_WORK_START_ZERO_TURNAROUND =
            MONDAY_WORK_START;
    private static final LocalDateTime EXPECTED_DUE_DATE_MONDAY_WORK_START_ONE_HOUR_TURNAROUND =
            MONDAY_WORK_START.plusHours(1L);
    private static final LocalDateTime EXPECTED_DUE_DATE_MONDAY_WORK_START_ENTIRE_WORKDAY_TURNAROUND =
            TUESDAY_WORK_START;

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

    @Test
    public void testCalculateDueDateShouldReturnWorkStartNextDayWhenCreatedAtWorkStartAndTurnaroundTimeIsEntireWorkday() {
        LocalDateTime actual = underTest.calculateDueDate(MONDAY_WORK_START, TURNAROUND_TIME_ENTIRE_WORKDAY);

        assertEquals(EXPECTED_DUE_DATE_MONDAY_WORK_START_ENTIRE_WORKDAY_TURNAROUND, actual);
    }
}