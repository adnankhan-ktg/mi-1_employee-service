package com.intelliatech.employeeservice.repositories;

import com.intelliatech.employeeservice.dtos.EmployeeDto;
import com.intelliatech.employeeservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {

    List<Employee> findByDepartmentId(int departmentId);
//    void DeleteByEmployeeId(int id);
    Employee findByEmployeeId(int id);
}
