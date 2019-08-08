package com.aszoke.assignment.duedatecalculator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DueDateCalculatorTest {

    private static final String TEST_CREATION_DATE_TIME_STRING = "2019-08-08T19:15:19";
    private static final LocalDateTime TEST_CREATION_DATE_TIME = LocalDateTime.parse(TEST_CREATION_DATE_TIME_STRING);
    private static final int TEST_TURNAROUND_TIME = 1;
    private static final LocalDateTime EXPECTED_DUE_DATE = LocalDateTime.now();

    @Mock
    private LocalDateTimeSyntaxValidator localDateTimeSyntaxValidator;
    @Mock
    private TurnaroundTimeValidator turnaroundTimeValidator;
    @Mock
    private CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator;
    @Mock
    private Calculator calculator;

    @InjectMocks
    private DueDateCalculator underTest;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldPropagateExceptionWhenLocalDateTimeSyntaxValidationFails() {
        doThrow(new IllegalArgumentException()).when(localDateTimeSyntaxValidator).validate(TEST_CREATION_DATE_TIME_STRING);

        underTest.calculateDueDate(TEST_CREATION_DATE_TIME_STRING, TEST_TURNAROUND_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldPropagateExceptionWhenTurnaroundTimeValidationFails() {
        doNothing().when(localDateTimeSyntaxValidator).validate(TEST_CREATION_DATE_TIME_STRING);
        doThrow(new IllegalArgumentException()).when(turnaroundTimeValidator).validate(TEST_TURNAROUND_TIME);

        underTest.calculateDueDate(TEST_CREATION_DATE_TIME_STRING, TEST_TURNAROUND_TIME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldPropagateExceptionWhenCreatedDuringWorkingHoursValidationFails() {
        doNothing().when(localDateTimeSyntaxValidator).validate(TEST_CREATION_DATE_TIME_STRING);
        doNothing().when(turnaroundTimeValidator).validate(TEST_TURNAROUND_TIME);
        doThrow(new IllegalArgumentException()).when(createdDuringWorkingHoursValidator)
                .validate(TEST_CREATION_DATE_TIME);

        underTest.calculateDueDate(TEST_CREATION_DATE_TIME_STRING, TEST_TURNAROUND_TIME);
    }

    @Test
    public void testCalculateDueDateShouldPropagateResultFromCalculatorWhenArgumentsAreValid() {
        doNothing().when(localDateTimeSyntaxValidator).validate(TEST_CREATION_DATE_TIME_STRING);
        doNothing().when(turnaroundTimeValidator).validate(TEST_TURNAROUND_TIME);
        doNothing().when(createdDuringWorkingHoursValidator).validate(TEST_CREATION_DATE_TIME);
        when(calculator.calculateDueDate(TEST_CREATION_DATE_TIME, TEST_TURNAROUND_TIME))
                .thenReturn(EXPECTED_DUE_DATE);

        LocalDateTime actual = underTest.calculateDueDate(TEST_CREATION_DATE_TIME_STRING, TEST_TURNAROUND_TIME);

        assertEquals(EXPECTED_DUE_DATE, actual);
    }
}