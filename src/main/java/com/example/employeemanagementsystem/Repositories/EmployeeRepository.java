package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
