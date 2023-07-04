package com.portfolio.trip_project.repository;

import com.portfolio.trip_project.entity.ERole;
import com.portfolio.trip_project.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(ERole name);
}