package com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories;

import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

    Department findByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentId(String id);
}

//    Department findByDepartmentName(String departmentName);
//}
