package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

public class Application {

    private static final LocalDateTimeValidator localDateTimeValidator = new LocalDateTimeValidator();
    private static final TurnaroundTimeValidator turnaroundTimeValidator = new TurnaroundTimeValidator();
    private static final CreatedDuringWorkingHoursValidator createdDuringWorkingHoursValidator = new CreatedDuringWorkingHoursValidator();

    public static void main(String[] args) {
        String creationDateTimeString = "2019-08-08T16:22:44";
        int turnaroundTimeInMinutes = 1;

        localDateTimeValidator.validate(creationDateTimeString);
        turnaroundTimeValidator.validate(turnaroundTimeInMinutes);
        LocalDateTime creationDateTime = LocalDateTime.parse(creationDateTimeString);
        createdDuringWorkingHoursValidator.validate(creationDateTime);

        DueDateCalculator dueDateCalculator = new DueDateCalculator();

        LocalDateTime dueDateTime = dueDateCalculator.calculateDueDate(creationDateTime, turnaroundTimeInMinutes);

        System.out.println(String.format("Task created at %s is due at %s.",
                creationDateTime,
                dueDateTime));
    }
}