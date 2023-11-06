package com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories;

import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee WHERE first_name = :firstName AND last_name = :lastName", nativeQuery = true)
    Employee findByFirstNameAndLastName(String firstName, String lastName);


    @Query(value = "SELECT * FROM employee WHERE department_id = :departmentId" , nativeQuery = true)
    List<Employee> findAllEmployeesByDepartmentId(String departmentId);



}

