package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    private final LocalDateTimeValidator localDateTimeValidator;
    private final TurnaroundTimeValidator turnaroundTimeValidator;
    private final CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator;

    DueDateCalculator(LocalDateTimeValidator localDateTimeValidator, TurnaroundTimeValidator turnaroundTimeValidator, CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator) {
        this.localDateTimeValidator = localDateTimeValidator;
        this.turnaroundTimeValidator = turnaroundTimeValidator;
        this.createdDuringWorkingHoursValidator = createdDuringWorkingHoursValidator;
    }

    LocalDateTime calculateDueDate(String creationDateTimeString, int turnaroundTimeInHours) {
        localDateTimeValidator.validate(creationDateTimeString);
        turnaroundTimeValidator.validate(turnaroundTimeInHours);

        LocalDateTime creationDateTime = LocalDateTime.parse(creationDateTimeString);
        createdDuringWorkingHoursValidator.validate(creationDateTime);

        return creationDateTime;
    }
}
