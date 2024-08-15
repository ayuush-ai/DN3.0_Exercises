package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeCustomProjection {
    
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getFullNameAndEmail();
}
