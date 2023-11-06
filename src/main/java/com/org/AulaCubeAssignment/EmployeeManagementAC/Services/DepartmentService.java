package com.org.AulaCubeAssignment.EmployeeManagementAC.Services;

import com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling.NotFoundException;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Department;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Employee;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories.DepartmentRepository;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

//    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
//        this.departmentRepository = departmentRepository;
//        this.employeeRepository = employeeRepository;
//    }


    public Department createDepartment(Department department){

//        String existId=department.getDepartmentId();
//        boolean existsDepartment=departmentRepository.existsById(existId);
//
//        if(existsDepartment){
//            throw new AlreadyExistsException("Department with ID " + existId + " already exists.");
//        }

        return  departmentRepository.save(department);


    }

    public Department getDepartmentById(String id) throws NotFoundException {
        Optional<Department> department = departmentRepository.findByDepartmentId(id);

        if (department.isPresent()) {
            return department.get();
        } else {
            throw new NotFoundException("Department with ID " + id + " does not exist.");
        }
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department updateDepartment, String Id) throws NotFoundException {
        Optional<Department> department = departmentRepository.findByDepartmentId(Id);

        if (!department.isPresent()) {
            throw new NotFoundException("Department with ID " + Id + " does not exist.");
        }

        Department existingDepartment = department.get();
        existingDepartment.setDepartmentId(updateDepartment.getDepartmentId());
        existingDepartment.setDepartmentName(updateDepartment.getDepartmentName());
        existingDepartment.setUpdatedAt(updateDepartment.getUpdatedAt());

        return departmentRepository.save(existingDepartment);
    }

    public void deleteById(String Id) throws NotFoundException{

        Boolean exists=departmentRepository.existsById(Id);

        if(!exists){
            throw new NotFoundException("Department with ID " + Id + " does not exists.");
        }

        departmentRepository.deleteById(Id);
    }

//    public void displayDepartmentWithEmployees(List<Department> departments) {
//        for (Department department : departments) {
//            System.out.println("Department: " + department.getDepartmentName());
//            List<Employee> employees = department.getEmployees();
//            for (Employee employee : employees) {
//                System.out.println("- Employee: " + employee.getFirstName() + " " + employee.getLastName());
//            }
//        }
//    }

    public Department getDepartmentByDepartmentName(String departmentName) {

        Department department=departmentRepository.findByDepartmentName(departmentName);


            return department;



    }

    public List<Employee> findEmployeesByDepartmentName(String DepartmentName) throws NotFoundException {

        List<Employee> list = new ArrayList<>();

        Department department = getDepartmentByDepartmentName(DepartmentName);

        String Id = null;
        if (department != null) {
            Id = department.getDepartmentId();
        }

        list = employeeRepository.findAllEmployeesByDepartmentId(Id);

        return list;


    }


}

