package com.lucky.department_service.client;

import com.lucky.department_service.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("/employees/dep/{departmentid}")
    public List<Employee> getEmployeeByDepartment(@PathVariable int departmentid);

    }
