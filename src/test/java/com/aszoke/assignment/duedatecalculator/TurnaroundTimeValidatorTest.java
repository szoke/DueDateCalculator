package com.aszoke.assignment.duedatecalculator;

import org.junit.Test;

public class TurnaroundTimeValidatorTest {

    private final TurnaroundTimeValidator underTest = new TurnaroundTimeValidator();

    @Test(expected = IllegalArgumentException.class)
    public void testValidateShouldThrowExceptionWhenTurnAroundTimeIsNegative() {
        underTest.validate(-1);
    }
}