package com.example.jpamanytomanydemo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appRoleId;

    @Column(unique = true)
    private String role;
    private String description;

    @OneToMany(mappedBy = "appRole")
    private List<AppUserRole> userRoles = new ArrayList<>();

    public int getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(int appRoleId) {
        this.appRoleId = appRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AppUserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<AppUserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
