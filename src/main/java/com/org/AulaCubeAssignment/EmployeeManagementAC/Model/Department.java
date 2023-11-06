package com.org.AulaCubeAssignment.EmployeeManagementAC.Model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="department")
public class Department {

    @Id
    String departmentId;
    String departmentName;
    Date createdAt;
    Date updatedAt;
}
