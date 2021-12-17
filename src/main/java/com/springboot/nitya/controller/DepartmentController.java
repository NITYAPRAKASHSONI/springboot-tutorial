package com.springboot.nitya.controller;

import com.springboot.nitya.model.Department;
import com.springboot.nitya.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
      return   new ResponseEntity<Department>(departmentService.saveDepartment(department),HttpStatus.CREATED);
    }

    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId){
        return new ResponseEntity<Department>(departmentService.getDepartmentById(departmentId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") long departmentId,
                                                           @RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.updateDepartmentById(department,departmentId),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteById(@PathVariable("id") long departmentId){
        departmentService.deleteById(departmentId);
        return new ResponseEntity<String>(departmentId  +  " department id is successfully deleted ",HttpStatus.OK);
    }


}
