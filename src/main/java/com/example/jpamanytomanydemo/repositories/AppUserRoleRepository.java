package com.example.jpamanytomanydemo.repositories;

import com.example.jpamanytomanydemo.models.AppUserRole;
import com.example.jpamanytomanydemo.models.AppUserRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, AppUserRoleKey> {
}
