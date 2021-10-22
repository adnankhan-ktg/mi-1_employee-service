package com.intelliatech.employeeservice.services;

import com.intelliatech.employeeservice.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByDepartmentId(int departmentId);
}
