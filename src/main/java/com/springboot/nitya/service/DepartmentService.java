package com.springboot.nitya.service;

import com.springboot.nitya.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(long departmentId);


    Department updateDepartmentById(Department department, long departmentId);

    void deleteById(long departmentId);
}
