package com.example.employeemanagementsystem.Services.Impl;

import com.example.employeemanagementsystem.Entities.Department;
import com.example.employeemanagementsystem.Repositories.DepartmentRepository;
import com.example.employeemanagementsystem.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
     DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department, Integer deptId) {
        department.setId(deptId);
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Integer deptId) {
        return departmentRepository.findById(deptId).get();
    }

    @Override
    public List<Department> departments() {
        return departmentRepository.findAll();
    }

    @Override
    public Void deleteDepartment(Integer deptId) {
        departmentRepository.deleteById(deptId);
        return null;
    }
}
