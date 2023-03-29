package com.example.employeemanagementsystem.Services.Impl;

import com.example.employeemanagementsystem.Entities.Employee;
import com.example.employeemanagementsystem.Repositories.EmployeeRepository;
import com.example.employeemanagementsystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
     EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee =employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer employeeId) {
        Employee emp = employeeRepository.findById(employeeId).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.setSalary(employee.getSalary());
        emp.setDept(employee.getDept());
        return employeeRepository.save(emp);
    }

    @Override
    public Void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
        return null;
    }
}
