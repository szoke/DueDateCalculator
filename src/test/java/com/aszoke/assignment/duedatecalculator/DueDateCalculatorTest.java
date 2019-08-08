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

    private static final String TEST_CREATION_DATE_TIME_AS_STRING = "2019-08-08T16:30:55";
    private static final LocalDateTime TEST_CREATION_DATE_TIME_AS_LOCAL_DATE_TIME =
            LocalDateTime.parse(TEST_CREATION_DATE_TIME_AS_STRING);
    private static final int TEST_TURNAROUND_TIME_ZERO = 0;

    @Mock
    private LocalDateTimeValidator localDateTimeValidator;
    @Mock
    private TurnaroundTimeValidator turnaroundTimeValidator;
    @Mock
    private CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator;

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
        verifyZeroInteractions(createdDuringWorkingHoursValidator);
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
        verifyZeroInteractions(createdDuringWorkingHoursValidator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateDueDateShouldThrowExceptionWhenCreatedDuringWorkingHoursValidationFails() {
        doNothing().when(localDateTimeValidator).validate(TEST_CREATION_DATE_TIME_AS_STRING);
        doNothing().when(turnaroundTimeValidator).validate(TEST_TURNAROUND_TIME_ZERO);
        doThrow(new IllegalArgumentException()).when(createdDuringWorkingHoursValidator)
                .validate(TEST_CREATION_DATE_TIME_AS_LOCAL_DATE_TIME);

        underTest.calculateDueDate(TEST_CREATION_DATE_TIME_AS_STRING, 1);

        verify(localDateTimeValidator).validate(TEST_CREATION_DATE_TIME_AS_STRING);
        verify(turnaroundTimeValidator).validate(TEST_TURNAROUND_TIME_ZERO);
        verify(createdDuringWorkingHoursValidator).validate(TEST_CREATION_DATE_TIME_AS_LOCAL_DATE_TIME);
    }

    @Test
    public void testCalculateDueDateShouldReturnCreationDateWhenTurnAroundTimeIsZero() {
        givenValidInputParameters();

        LocalDateTime actual = underTest.calculateDueDate(TEST_CREATION_DATE_TIME_AS_STRING, TEST_TURNAROUND_TIME_ZERO);

        verifyInputValidated(TEST_CREATION_DATE_TIME_AS_STRING, TEST_TURNAROUND_TIME_ZERO, TEST_CREATION_DATE_TIME_AS_LOCAL_DATE_TIME);
        assertEquals(TEST_CREATION_DATE_TIME_AS_LOCAL_DATE_TIME, actual);
    }

    private void givenValidInputParameters() {
        doNothing().when(localDateTimeValidator).validate(anyString());
        doNothing().when(turnaroundTimeValidator).validate(anyInt());
        doNothing().when(createdDuringWorkingHoursValidator).validate(any(LocalDateTime.class));
    }

    private void verifyInputValidated(String testCreationDateTimeString, int testTurnaroundTime,
                                      LocalDateTime testCreationDateTime) {
        verify(localDateTimeValidator).validate(testCreationDateTimeString);
        verify(turnaroundTimeValidator).validate(testTurnaroundTime);
        verify(createdDuringWorkingHoursValidator).validate(testCreationDateTime);
    }
}