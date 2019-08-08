package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

import java.time.format.DateTimeParseException;

public class DueDateCalculatorTest {

    private DueDateCalculator underTest = new DueDateCalculator();

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenCreationDateTimeIsNull() {
        underTest.calculateDueDate(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenCreationDateTimeIsEmpty() {
        underTest.calculateDueDate("", 1);
    }

    @Test(expected = DateTimeParseException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenCreationDateTimeCannotBeParsed() {
        underTest.calculateDueDate("asd987", 1);
    }

    // How do you know if the exception was thrown because the turnaround time is negative or
    // because the creation date-time cannot be parsed? The class under test is doing do much
    // already and violates the single responsibility principle.
    // We could assert the message in the exception but that may make the test too rigid.
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenTurnAroundTimeIsNegative() {
        underTest.calculateDueDate("2019-08-08T12:22:33", -1);
    }
}