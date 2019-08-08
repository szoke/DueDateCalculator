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
}