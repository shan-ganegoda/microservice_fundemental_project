package com.lucky.department_service.controller;

import com.lucky.department_service.client.EmployeeClient;
import com.lucky.department_service.model.Department;
import com.lucky.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repo;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add:{}" , department);
        return repo.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAll() {
        LOGGER.info("Department find}");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable int id) {
        LOGGER.info("Department find:id={}" , id);
        return repo.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllWithEmployees() {
        LOGGER.info("Department find}");
        List<Department> departments = repo.findAll();

        departments.forEach(d -> d.setEmployees(employeeClient.getEmployeeByDepartment(d.getId())));

        return departments;
    }
}
