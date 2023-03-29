package com.example.employeemanagementsystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(mappedBy ="dept",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Employee> employees;
}
