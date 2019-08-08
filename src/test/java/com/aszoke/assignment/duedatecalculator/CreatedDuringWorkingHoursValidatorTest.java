package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CreatedDuringWorkingHoursValidatorTest {

    // With some more effort this could be transformed into parametrized tests or TestNG's DataProvider would come in handy

    private static final LocalTime WORK_START = LocalTime.of(9, 0, 0);
    private static final LocalTime ONE_MINUTE_BEFORE_WORK_START = WORK_START.minusMinutes(1L);
    private static final LocalTime ONE_MINUTE_AFTER_WORK_START = WORK_START.plusMinutes(1L);

    private static final LocalTime WORK_END = LocalTime.of(17, 0, 0);
    private static final LocalTime ONE_MINUTE_BEFORE_WORK_END = WORK_END.minusMinutes(1L);
    private static final LocalTime ONE_MINUTE_AFTER_WORK_END = WORK_END.plusMinutes(1L);

    private static final LocalDate MONDAY = LocalDate.of(2019, 8, 5);

    private static final LocalDateTime MONDAY_NOON = LocalDateTime.of(MONDAY, LocalTime.NOON);
    private static final LocalDateTime MONDAY_ONE_MINUTE_BEFORE_WORK_START = LocalDateTime.of(MONDAY, ONE_MINUTE_BEFORE_WORK_START);
    private static final LocalDateTime MONDAY_WORK_START = LocalDateTime.of(MONDAY, WORK_START);
    private static final LocalDateTime MONDAY_ONE_MINUTE_AFTER_WORK_START = LocalDateTime.of(MONDAY, ONE_MINUTE_AFTER_WORK_START);
    private static final LocalDateTime MONDAY_ONE_MINUTE_BEFORE_WORK_END = LocalDateTime.of(MONDAY, ONE_MINUTE_BEFORE_WORK_END);
    private static final LocalDateTime MONDAY_WORK_END = LocalDateTime.of(MONDAY, WORK_END);
    private static final LocalDateTime MONDAY_ONE_MINUTE_AFTER_WORK_END = LocalDateTime.of(MONDAY, ONE_MINUTE_AFTER_WORK_END);

    private static final LocalDateTime TUESDAY_NOON = MONDAY_NOON.plusDays(1L);
    private static final LocalDateTime WEDNESDAY_NOON = MONDAY_NOON.plusDays(2L);
    private static final LocalDateTime THURSDAY_NOON = MONDAY_NOON.plusDays(3L);
    private static final LocalDateTime FRIDAY_NOON = MONDAY_NOON.plusDays(4L);
    private static final LocalDateTime SATURDAY_NOON = MONDAY_NOON.plusDays(5L);
    private static final LocalDateTime SUNDAY_NOON = MONDAY_NOON.plusDays(6L);

    private final CreatedDuringWorkingHoursValidator underTest = new CreatedDuringWorkingHoursValidator();

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtMondayNoon() {
        underTest.validate(MONDAY_NOON);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtTuesdayNoon() {
        underTest.validate(TUESDAY_NOON);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtWednesdayNoon() {
        underTest.validate(WEDNESDAY_NOON);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtThursdayNoon() {
        underTest.validate(THURSDAY_NOON);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtFridayNoon() {
        underTest.validate(FRIDAY_NOON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowWhenBugWasCreatedAtSaturdayNoon() {
        underTest.validate(SATURDAY_NOON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldNotThrowWhenBugWasCreatedAtSundayNoon() {
        underTest.validate(SUNDAY_NOON);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowWhenBugWasCreatedAtMondayOneMinuteBeforeWorkStart() {
        underTest.validate(MONDAY_ONE_MINUTE_BEFORE_WORK_START);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtMondayWorkStart() {
        underTest.validate(MONDAY_WORK_START);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtMondayOneMinuteAfterWorkStart() {
        underTest.validate(MONDAY_ONE_MINUTE_AFTER_WORK_START);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtMondayOneMinuteBeforeWorkEnd() {
        underTest.validate(MONDAY_ONE_MINUTE_BEFORE_WORK_END);
    }

    @Test
    public void testValidateShouldNotThrowWhenBugWasCreatedAtMondayWorkEnd() {
        underTest.validate(MONDAY_WORK_END);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowWhenBugWasCreatedAtMondayOneMinuteAfterWorkEnd() {
        underTest.validate(MONDAY_ONE_MINUTE_AFTER_WORK_END);
    }
}