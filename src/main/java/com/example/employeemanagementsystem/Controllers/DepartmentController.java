package com.example.employeemanagementsystem.Controllers;

import com.example.employeemanagementsystem.Entities.Department;
import com.example.employeemanagementsystem.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {
    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/addDepartment")
    public String showAddDeptForm(Model model){
        Department department = new Department();
        model.addAttribute(department);
        return "add-department";
    }

    @PostMapping("/addDepartment")
    public String addDepartment(@ModelAttribute Department department,Model model){
        departmentService.addDepartment(department);
        model.addAttribute("departments",departmentService.departments());
        return "department-list";

    }
    @GetMapping("/updateDepartment/{deptId}")
    public String updateDeptFrom(@PathVariable("deptId") Integer deptId, Model model){
        Department department = departmentService.getDepartmentById(deptId);
        model.addAttribute(department);
        return "update-department";
    }
    @PostMapping("/updateDepartment/{deptId}")
    public String updateDept(@ModelAttribute Department department,@PathVariable("deptId") Integer deptId,Model model){
        departmentService.updateDepartment(department,deptId);
        model.addAttribute("departments",departmentService.departments());
        return "department-list";

    }
    @GetMapping("/deleteDepartment/{deptId}")
    public String deleteDept(@PathVariable("deptId") Integer deptId, Model model){
        departmentService.deleteDepartment(deptId);
        model.addAttribute("departments",departmentService.departments());
        return "department-list";
    }
    @GetMapping("/allDepartment")
    public String allDepartment(Model model){
        model.addAttribute("departments",departmentService.departments());
        return "department-list";
    }
}
