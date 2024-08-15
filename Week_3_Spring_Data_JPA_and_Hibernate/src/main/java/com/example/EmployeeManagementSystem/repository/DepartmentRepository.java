package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Find department by name containing a specific string
    Department findByNameContaining(String nameFragment);

    // Custom query using @Query
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Department findDepartmentByName(@Param("name") String name);
}
