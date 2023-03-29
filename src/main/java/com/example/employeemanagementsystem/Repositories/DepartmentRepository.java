package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
