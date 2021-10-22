package com.intelliatech.employeeservice.serviceimpl;

import ch.qos.logback.classic.jmx.MBeanUtil;
import com.intelliatech.employeeservice.dtos.EmployeeDto;
import com.intelliatech.employeeservice.models.Employee;
import com.intelliatech.employeeservice.repositories.EmployeeDao;
import com.intelliatech.employeeservice.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {

        log.info("inside the |addEmployee method -->EmployeeServiceImpl");

        Employee employee = new Employee();
        EmployeeDto employeeDto1 = new EmployeeDto();

        //for copy object properties left to right
        BeanUtils.copyProperties(employeeDto,employee);

        log.info("send object for the save in the table.");

        //for back ........
        BeanUtils.copyProperties(this.employeeDao.save(employee), employeeDto1);
        log.info("return from ||addEmployee method -->EmployeeServiceImpl");

         return employeeDto1;

    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartmentId(int departmentId) {

        log.info("inside the getEmployeesByDepartmentId method-->EmployeeService.");
        
        log.info("Id give to the Department DAO..for get the all employee by department Id");
        List<Employee> listOfEmployee = this.employeeDao.findByDepartmentId(departmentId);
        List<EmployeeDto> listOfEmployeeDto = new ArrayList<>();


        //convert list of Employee to list of EmployeeDto
        for(Employee e : listOfEmployee)
        {
            if(!ObjectUtils.isEmpty(e)) {
                EmployeeDto ed = new EmployeeDto();
                BeanUtils.copyProperties(e, ed);
                listOfEmployeeDto.add(ed);
            }

        }

        log.info("return from the getEmployeeByDepartmentId-->DepartmentService");
        return listOfEmployeeDto;
        
        
    }
}
