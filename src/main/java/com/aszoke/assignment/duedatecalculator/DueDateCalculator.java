package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    private final LocalDateTimeSyntaxValidator localDateTimeSyntaxValidator;
    private final TurnaroundTimeValidator turnaroundTimeValidator;
    private final CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator;
    private final Calculator calculator;

    DueDateCalculator(LocalDateTimeSyntaxValidator localDateTimeSyntaxValidator, TurnaroundTimeValidator turnaroundTimeValidator,
                      CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator, Calculator calculator) {
        this.localDateTimeSyntaxValidator = localDateTimeSyntaxValidator;
        this.turnaroundTimeValidator = turnaroundTimeValidator;
        this.createdDuringWorkingHoursValidator = createdDuringWorkingHoursValidator;
        this.calculator = calculator;
    }

    LocalDateTime calculateDueDate(String creationDateTimeString, int turnaroundTimeInHours) {
        localDateTimeSyntaxValidator.validate(creationDateTimeString);
        turnaroundTimeValidator.validate(turnaroundTimeInHours);
        LocalDateTime creationDateTime = LocalDateTime.parse(creationDateTimeString);
        createdDuringWorkingHoursValidator.validate(creationDateTime);

        return calculator.calculateDueDate(creationDateTime, turnaroundTimeInHours);
    }
}
