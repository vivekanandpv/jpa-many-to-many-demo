package com.example.jpamanytomanydemo.repositories;

import com.example.jpamanytomanydemo.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
}
