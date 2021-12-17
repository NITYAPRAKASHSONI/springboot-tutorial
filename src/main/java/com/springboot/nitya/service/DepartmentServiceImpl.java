package com.springboot.nitya.service;

import com.springboot.nitya.model.Department;
import com.springboot.nitya.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }

    @Override
    public Department updateDepartmentById(Department department, long departmentId) {
        Department existedDepartment=departmentRepository.findById(departmentId).orElseThrow();
        existedDepartment.setDepartmentName(department.getDepartmentName());
        existedDepartment.setDepartmentAddress(department.getDepartmentAddress());
        existedDepartment.setDepartmentCode(department.getDepartmentCode());
        return existedDepartment;

    }

    @Override
    public void deleteById(long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow();
        departmentRepository.deleteById(departmentId);
    }
}
