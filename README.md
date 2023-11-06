# Swagger- http://13.210.217.115:8080/swagger-ui/index.html#/


# EmployeeManagementAC
Aula Cube Assignment

# Frameworks and language used:
-     Java
-     Spring Boot
-     PostgreSQL and MongoDB database
-     Postman
-     AWS EC2 instance for deployment. Note: the deployed version used MySQL Database.

#  Dependencies- 

 -  Springboot dev tools
 -  Spring Web
 -  Spring Data JPA
 -  Lombok
 -  Spring Data Mongo-DB
 -  PostgreSQl Driver


## Data Flow


*  **Model** :
  There are two Models class in this application.
    * Employee Model Class.
    * Department Model Class

* **Controller** :

  There are two Controller classse in this application.

    * EmployeeController Class.
    * DepartmentController Class.

* **Service** :

  There are two Service class in this application.

    * EmployeeService Class.
    * DepartmentService Class.
  
* **Repository** :

  There are two Repository Interfaces in this application.

    * EmployeeRepository Interface.
    * DepartmentRepository Interface.
 

  * **GlobalExceptionHandler class** :
    #### In this class I have handled the exceptions that generates in project inbuild as well as custom.
 
    * AlreadyExistsException
    * NotFoundException
    

## Employee Endpoints

### Create Employee
- **Description**: Create a new employee.
- **URL**: `/v1/employees`
- **Method**: `POST`

### Get Employee by ID
- **Description**: Retrieve an employee by their ID.
- **URL**: `/v1/employees/{id}`
- **Method**: `GET`

### Get All Employees
- **Description**: Retrieve a list of all employees.
- **URL**: `/v1/employees`
- **Method**: `GET`

### Update Employee
- **Description**: Update an employee's information.
- **URL**: `/v1/employees/{id}`
- **Method**: `PUT`

### Delete Employee
- **Description**: Delete an employee by their ID.
- **URL**: `/v1/employees/{id}`
- **Method**: `DELETE`

### Get All Employees Count
- **Description**: Retrieve the total count of employees.
- **URL**: `/v1/employees/count`
- **Method**: `GET`

### Get Department by Employee Name
- **Description**: Retrieve the department name for an employee by their full name.
- **URL**: `/v1/employees/department/{fullName}`
- **Method**: `GET`


## Department Controller Endpoints

### Create Department
- **Description**: Create a new department.
- **URL**: `/v1/departments`
- **Method**: `POST`

### Get Department by ID
- **Description**: Retrieve a department by its ID.
- **URL**: `/v1/departments/{id}`
- **Method**: `GET`

### Get All Departments
- **Description**: Retrieve a list of all departments.
- **URL**: `/v1/departments`
- **Method**: `GET`

### Update Department
- **Description**: Update a department's information.
- **URL**: `/v1/departments/{id}`
- **Method**: `PUT`

### Delete Department
- **Description**: Delete a department by its ID.
- **URL**: `/v1/departments/{id}`
- **Method**: `DELETE`

### Get Department by Department Name
- **Description**: Retrieve a department by its name.
- **URL**: `/v1/departments/departmentName/{departmentName}`
- **Method**: `GET`

### Find Employees by Department Name
- **Description**: Retrieve a list of employees in a department by the department's name.
- **URL**: `/v1/departments/{departmentName}/employees`
- **Method**: `GET`



* **Database**

    * I have used PostgreSQL Database and MongoDB to store the data.

## Project Summary

* The Employee Management System using Spring Boot is a comprehensive web-based application designed to simplify and enhance the management of employee data within an organization. This application offers an intuitive and user-friendly interface,
  facilitating CRUD operations on Employee and Department entities.
   
