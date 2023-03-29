package com.example.employeemanagementsystem.Services;

import com.example.employeemanagementsystem.Entities.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department department);
    Department updateDepartment(Department department,Integer deptId);
    Department getDepartmentById(Integer deptId);
    List<Department> departments();
    Void deleteDepartment(Integer deptId);
}
