package com.lucky.employee_service.repository;

import com.lucky.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeServiceRepository {

    private List<Employee> employees = new ArrayList<Employee>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Integer id){
        return employees.stream().filter(e -> e.id().equals(id)).findFirst().orElse(null);
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartment(Integer departmentId){
        return employees.stream().filter(a -> a.departmentid().equals(departmentId)).toList();
    }
}
