package com.aszoke.assignment.duedatecalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.format.DateTimeParseException;

import static org.mockito.Mockito.*;

public class DueDateCalculatorTest {

    @Mock
    private LocalDateTimeValidator localDateTimeValidator;
    @Mock
    private TurnaroundTimeValidator turnaroundTimeValidator;

    @InjectMocks
    private DueDateCalculator underTest;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenCreationDateValidationFails() {
        String testCreationDateTime = "test";
        doThrow(new IllegalArgumentException()).when(localDateTimeValidator).validate(testCreationDateTime);

        underTest.calculateDueDate(testCreationDateTime, 1);

        verify(localDateTimeValidator).validate(testCreationDateTime);
        verifyZeroInteractions(turnaroundTimeValidator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenTurnaroundTimeValidationFails() {
        String testCreationDateTime = "test";
        int testTurnaroundTime = 1;
        doNothing().when(localDateTimeValidator).validate(testCreationDateTime);
        doThrow(new IllegalArgumentException()).when(turnaroundTimeValidator).validate(testTurnaroundTime);

        underTest.calculateDueDate(testCreationDateTime, 1);

        verify(localDateTimeValidator).validate(testCreationDateTime);
        verify(turnaroundTimeValidator).validate(testTurnaroundTime);
    }
}