package com.lucky.department_service.repository;

import com.lucky.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<Department>();

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Integer id){
        return departments.stream().filter(department -> department.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Department> findAll(){
        return departments;
    }
}
