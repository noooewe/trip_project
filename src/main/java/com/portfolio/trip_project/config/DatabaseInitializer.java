package com.portfolio.trip_project.config;

import com.portfolio.trip_project.entity.ERole;
import com.portfolio.trip_project.entity.RoleEntity;
import com.portfolio.trip_project.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Autowired
    public DatabaseInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.findByName(ERole.ROLE_ADMIN) == null) {
            RoleEntity adminRole = new RoleEntity(ERole.ROLE_ADMIN);
            roleRepository.save(adminRole);
        }
        if (roleRepository.findByName(ERole.ROLE_USER) == null) {
            RoleEntity userRole = new RoleEntity(ERole.ROLE_USER);
            roleRepository.save(userRole);
        }
    }
}