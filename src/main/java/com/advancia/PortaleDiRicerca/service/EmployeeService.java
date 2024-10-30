package com.advancia.PortaleDiRicerca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advancia.PortaleDiRicerca.entity.Employee;
import com.advancia.PortaleDiRicerca.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> searchEmployees(String departmentName, String streetAddress, String countryName, 
                                          String employeeName, String regionName, Double minSalary, Double maxSalary) {
        return employeeRepository.searchEmployees(departmentName, streetAddress, countryName, employeeName, regionName, minSalary, maxSalary);
    }
}
