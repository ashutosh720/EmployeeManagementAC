package com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
