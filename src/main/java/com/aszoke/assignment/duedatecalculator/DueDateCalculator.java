package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    private final LocalDateTimeValidator localDateTimeValidator;
    private final TurnaroundTimeValidator turnaroundTimeValidator;

    DueDateCalculator(LocalDateTimeValidator localDateTimeValidator, TurnaroundTimeValidator turnaroundTimeValidator) {
        this.localDateTimeValidator = localDateTimeValidator;
        this.turnaroundTimeValidator = turnaroundTimeValidator;
    }

    LocalDateTime calculateDueDate(String creationDateTime, int turnaroundTimeInHours) {
        localDateTimeValidator.validate(creationDateTime);
        turnaroundTimeValidator.validate(turnaroundTimeInHours);

        return null;
    }
}
