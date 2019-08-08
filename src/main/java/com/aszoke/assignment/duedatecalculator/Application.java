package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        // In real world the parameters could come from command line args, file, networks, etc.
        String creationDateTimeString = "2019-08-08T16:22:44";
        int turnaroundTimeInHours = 9;

        // In real world we probably use a DI framework
        DueDateCalculator dueDateCalculator = new DueDateCalculator(
                new LocalDateTimeSyntaxValidator(),
                new TurnaroundTimeValidator(),
                new CreatedDuringWorkingHoursValidator(),
                new Calculator());

        LocalDateTime dueDateTime = dueDateCalculator.calculateDueDate(creationDateTimeString, turnaroundTimeInHours);

        System.out.println(String.format("Task created at %s with turnaroung time of %d hours is due at %s.",
                creationDateTimeString,
                turnaroundTimeInHours,
                dueDateTime));
    }
}