package com.example.EmployeeManagementSystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Return the current username or user ID
        return Optional.of("system"); // Replace "system" with actual user retrieval logic
    }
}
