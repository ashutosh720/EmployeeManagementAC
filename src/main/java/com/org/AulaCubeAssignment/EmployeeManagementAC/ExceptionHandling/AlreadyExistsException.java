package com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
