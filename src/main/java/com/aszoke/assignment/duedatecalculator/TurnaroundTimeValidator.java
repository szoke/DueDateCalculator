package com.aszoke.assignment.duedatecalculator;

class TurnaroundTimeValidator {

    void validate(int turnaroundTimeInHours) {
        if (turnaroundTimeInHours < 0) {
            throw new IllegalArgumentException("turnaroundTimeInHours must be greater or equal to 0.");
        }
    }
}
