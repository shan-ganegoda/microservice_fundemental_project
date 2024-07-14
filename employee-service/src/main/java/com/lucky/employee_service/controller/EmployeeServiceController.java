package com.lucky.employee_service.controller;

import com.lucky.employee_service.model.Employee;
import com.lucky.employee_service.repository.EmployeeServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeServiceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceController.class);

    @Autowired
    private EmployeeServiceRepository repo;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Creating employee : {}", employee);
        return repo.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("employee find");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        LOGGER.info("employee find: id={}", id);
        return repo.findById(id);
    }

    @GetMapping("/dep/{departmentid}")
    public List<Employee> getEmployeeByDepartment(@PathVariable int departmentid) {
        LOGGER.info("employee find: depatmentid={}", departmentid);
        return repo.findByDepartment(departmentid);
    }
}
