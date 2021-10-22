package com.intelliatech.employeeservice.controllers;

import com.intelliatech.employeeservice.dtos.EmployeeDto;
import com.intelliatech.employeeservice.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);


    //for add new employee in the database....
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        log.info("inside the addEmployee method of EmployeeController");

        log.info("send object to the service layer");
        EmployeeDto employeeDto1 = this.employeeService.addEmployee(employeeDto);
        if(employeeDto1 != null)
        {
            log.info("Object successfully saved");
            return ResponseEntity.status(HttpStatus.OK).body(employeeDto1);
        }else{
            log.info("Object not save due to some issue..");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<?> getEmployeeByDepartmentId(@PathVariable("departmentId") int departentId)
    {
        log.info("inside getEmployeeByDepartmentId method-->>Employee controller");

        log.info("DepartmentId send to the EmployeeService -->service");
        List<EmployeeDto> listOfEmployee = this.employeeService.getEmployeesByDepartmentId(departentId);

        log.info("return from the getEmployeeByDepartmentId method-->>Employee controller");
        return ResponseEntity.status(HttpStatus.OK).body(listOfEmployee);

    }





}
