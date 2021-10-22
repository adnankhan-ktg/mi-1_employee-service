package com.intelliatech.employeeservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {


    private int employeeId;
    private String firstName;
    private String lastName;
    private int departmentId;

}
