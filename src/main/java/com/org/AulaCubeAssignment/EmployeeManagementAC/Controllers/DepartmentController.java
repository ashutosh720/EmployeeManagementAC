package com.org.AulaCubeAssignment.EmployeeManagementAC.Controllers;

import com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling.NotFoundException;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Department;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Employee;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return ResponseEntity.ok(createdDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        Optional<Department> department = Optional.ofNullable(departmentService.getDepartmentById(id));

        if (department.isPresent()) {
            // Department found, return it
            return ResponseEntity.ok(department.get());
        } else {
            // Department not found, return an appropriate response
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departmentList = departmentService.getAllDepartments();
        return ResponseEntity.ok(departmentList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department, @PathVariable("id") String id) throws NotFoundException {
        Department updatedDepartment = departmentService.updateDepartment(department, id);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") String id) throws NotFoundException {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/departmentName/{departmentName}")
    public ResponseEntity<Department> getDepartmentByDepartmentName(@PathVariable("departmentName") String departmentName) {
        Department department = departmentService.getDepartmentByDepartmentName(departmentName);
        if (department == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(department);
        }
    }

    @GetMapping("/{departmentName}/employees")
    public ResponseEntity<List< Employee>> findEmployeesByDepartmentName(@PathVariable("departmentName") String departmentName) throws NotFoundException {
        List<Employee> employeeList = departmentService.findEmployeesByDepartmentName(departmentName);
        return ResponseEntity.ok(employeeList);
    }

}

