package com.org.AulaCubeAssignment.EmployeeManagementAC.Services;

import com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling.AlreadyExistsException;
import com.org.AulaCubeAssignment.EmployeeManagementAC.ExceptionHandling.NotFoundException;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Department;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Model.Employee;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories.DepartmentRepository;
import com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(Employee employee){

        long existId=employee.getId();
        boolean existsEmployee=employeeRepository.existsById(existId);

        if(existsEmployee){
            throw new AlreadyExistsException("Employee with ID " + existId + " already exists.");
        }

        return employeeRepository.save(employee);

    }

    public Employee getEmployeeById (long Id) throws NotFoundException{

        Boolean exists=employeeRepository.existsById(Id);

        if(!exists){
            throw new NotFoundException("Employee with ID " + Id + " does not exists.");
        }

        Employee emp=employeeRepository.findById(Id).get();

        return emp;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee updateEmployee, long Id) throws NotFoundException{

        Boolean exists=employeeRepository.existsById(Id);

        if(!exists){
            throw new NotFoundException("Employee with ID " + Id + " does not exists.");
        }

            Employee exist=employeeRepository.findById(Id).get();
            exist.setId(updateEmployee.getId());
            exist.setFirstName(updateEmployee.getFirstName());
            exist.setLastName(updateEmployee.getLastName());
            exist.setEmail(updateEmployee.getEmail());
            exist.setDepartmentId(updateEmployee.getDepartmentId());
            exist.setUpdatedAt(updateEmployee.getUpdatedAt());

            return employeeRepository.save(exist);


    }

    public void deleteById(long Id) throws NotFoundException{

        Boolean exists=employeeRepository.existsById(Id);

        if(!exists){
            throw new NotFoundException("Employee with ID " + Id + " does not exists.");
        }

        employeeRepository.deleteById(Id);
    }

    public int allEmployees(){
        List<Employee> list=employeeRepository.findAll();
        return list.size();
    }

    public String findDepartmentByEmployeeName(String fullName) throws NotFoundException{

        String firstName="";
        String lastName="";
        if (fullName != null && !fullName.trim().isEmpty()) {
            String[] nameParts = fullName.split("\\s+");
            if (nameParts.length == 2) {
                firstName = nameParts[0];
                lastName = nameParts[1];
            }
        }
        Employee emp=employeeRepository.findByFirstNameAndLastName(firstName,lastName);

        if(emp!=null) {


            String departmentId = emp.getDepartmentId();

            Department department = departmentRepository.findById(departmentId).get();

            String departmentName = department.getDepartmentName();

            return departmentName;
        }

        else{
            throw new NotFoundException("Does not Exist");
        }



    }




}
