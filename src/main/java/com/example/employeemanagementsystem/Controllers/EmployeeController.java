package com.example.employeemanagementsystem.Controllers;

import com.example.employeemanagementsystem.Entities.Employee;
import com.example.employeemanagementsystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmployee")
    public String addEmp(@ModelAttribute Employee employee, Model model) {
       employeeService.addEmployee(employee);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "employee-list";
    }
    @GetMapping("/addEmployee")
    public String addEmpForm(Model model){
        Employee employee = new Employee();
        model.addAttribute(employee);
        return "add-employee";
    }

    @PostMapping("/updateEmployee/{employeeId}")
    public String updateEmp(@ModelAttribute Employee employee, @PathVariable("employeeId") Integer empId,
                            Model model) {
        employeeService.updateEmployee(employee, empId);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "employee-list";
    }
    @GetMapping("/updateEmployee/{employeeId}")
    public String showUpdateForm( @PathVariable("employeeId") Integer empId,
                            Model model) {
       Employee employee= employeeService.getEmployeeById(empId);
       model.addAttribute(employee);
        return "update-employee";
    }
    @GetMapping("/deleteEmployee/{employeeId}")
    public String deleteEmp(@PathVariable("employeeId") Integer empId, Model model) {
        employeeService.deleteEmployee(empId);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "employee-list";
    }

    @GetMapping(value = {"/allEmployee","/"})
    public String allEmployee(Model model) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employees", employeeList);
        return "employee-list";
    }

    @GetMapping("employee/{empId}")
    public String getEmployeeById(@PathVariable("empId") Integer empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute(employee);
        return "update-employee";
    }
}
