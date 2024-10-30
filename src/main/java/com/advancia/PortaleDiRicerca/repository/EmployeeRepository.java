package com.advancia.PortaleDiRicerca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.advancia.PortaleDiRicerca.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE "
         + "(:departmentName IS NULL OR e.department.departmentName = :departmentName) AND "
         + "(:city IS NULL OR e.department.location.city = :city) AND "
         + "(:countryName IS NULL OR e.department.location.country.countryName = :countryName) AND "
         + "(:employeeName IS NULL OR e.firstName LIKE %:employeeName%) AND "
         + "(:regionName IS NULL OR e.department.location.country.region.regionName = :regionName) AND "
         + "(:minSalary IS NULL OR e.salary >= :minSalary) AND "
         + "(:maxSalary IS NULL OR e.salary <= :maxSalary)")
    List<Employee> searchEmployees(
        @Param("departmentName") String departmentName,
        @Param("city") String city,
        @Param("countryName") String countryName,
        @Param("employeeName") String employeeName,
        @Param("regionName") String regionName,
        @Param("minSalary") Double minSalary,
        @Param("maxSalary") Double maxSalary
    );
}
