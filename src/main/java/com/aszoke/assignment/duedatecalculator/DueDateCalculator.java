package com.aszoke.assignment.duedatecalculator;

import java.time.LocalDateTime;

class DueDateCalculator {

    LocalDateTime calculateDueDate(LocalDateTime creationDateTime, int turnaroundTimeInHours) {

        return creationDateTime.plusHours((long) turnaroundTimeInHours);
    }
}
