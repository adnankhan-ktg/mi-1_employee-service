package com.intelliatech.employeeservice.services;

import com.intelliatech.employeeservice.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByDepartmentId(int departmentId);
    void deleteEmployeeByEmployeeId(int id);
    EmployeeDto getEmployeeByEmployeeId(int id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
}
