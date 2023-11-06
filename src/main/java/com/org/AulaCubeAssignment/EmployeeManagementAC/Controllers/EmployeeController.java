package com.org.AulaCubeAssignment.EmployeeManagementAC.Controllers;

import com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling.NotFoundException;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Employee;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) throws NotFoundException {
        Employee foundEmployee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(foundEmployee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) throws NotFoundException {
        Employee updatedEmployee = employeeService.updateEmployee(employee, id);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") long id) throws NotFoundException {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getAllEmployeesCount() {
        int count = employeeService.allEmployees();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/department/{fullName}")
    public ResponseEntity<String> getDepartmentByEmployeeName(@PathVariable("fullName") String fullName) throws NotFoundException {
        String departmentName = employeeService.findDepartmentByEmployeeName(fullName);
        return ResponseEntity.ok(departmentName);
    }

}

