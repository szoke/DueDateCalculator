package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {
        DueDateCalculator dueDateCalculator = new DueDateCalculator(
                new LocalDateTimeValidator(),
                new TurnaroundTimeValidator(),
                new CreatedDuringWorkingHoursValidator());

        String creationDateTime = "2019-08-08T16:22:44";

        LocalDateTime dueDateTime = dueDateCalculator.calculateDueDate(creationDateTime, 1);

        System.out.println(String.format("Task created at %s is due at %s.",
                creationDateTime,
                dueDateTime));
    }
}