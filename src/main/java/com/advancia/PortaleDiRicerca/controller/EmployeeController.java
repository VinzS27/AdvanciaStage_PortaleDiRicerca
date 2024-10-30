package com.advancia.PortaleDiRicerca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advancia.PortaleDiRicerca.entity.Employee;
import com.advancia.PortaleDiRicerca.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(
            @RequestParam(required = false) String departmentName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String countryName,
            @RequestParam(required = false) String employeeName,
            @RequestParam(required = false) String regionName,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary) {
        return employeeService.searchEmployees(departmentName, city, countryName, employeeName, regionName, minSalary, maxSalary);
    }
}
