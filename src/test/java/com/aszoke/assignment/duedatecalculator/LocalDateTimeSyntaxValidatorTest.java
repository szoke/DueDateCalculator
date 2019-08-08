package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

import java.time.format.DateTimeParseException;

public class LocalDateTimeSyntaxValidatorTest {

    private final LocalDateTimeSyntaxValidator underTest = new LocalDateTimeSyntaxValidator();

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowExceptionWhenCreationDateTimeIsNull() {
        underTest.validate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowExceptionWhenCreationDateTimeIsEmpty() {
        underTest.validate("");
    }

    @Test(expected = DateTimeParseException.class)
    public void testValidateShouldThrowExceptionWhenCreationDateTimeCannotBeParsed() {
        underTest.validate("asd987");
    }
}