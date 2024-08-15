package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    default void saveAllInBatch(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            save(employees.get(i));
            if (i % 20 == 0) {  // Flush after every 20 inserts
                flush();
            }
        }
    }
}
