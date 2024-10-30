package com.advancia.PortaleDiRicerca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.advancia.PortaleDiRicerca.entity.Department;
import com.advancia.PortaleDiRicerca.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
}