package com.example.employeemanagementsystem.Services;

import com.example.employeemanagementsystem.Entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    List<Employee> getAllEmployee();
    Employee updateEmployee(Employee employee,Integer employeeId);
    Void deleteEmployee(Integer employeeId);

}
