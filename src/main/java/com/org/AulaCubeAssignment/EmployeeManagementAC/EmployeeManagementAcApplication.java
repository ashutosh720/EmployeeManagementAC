package com.org.AulaCubeAssignment.EmployeeManagementAC;

import com.org.AulaCubeAssignment.EmployeeManagementAC.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@SpringBootApplication
public class EmployeeManagementAcApplication {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private MongoTemplate mongoTemplate;


	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementAcApplication.class, args);
	}

	public void run(String... args) throws Exception { System.out.println("-----------------" +mongoTemplate.getCollectionNames());}

}
