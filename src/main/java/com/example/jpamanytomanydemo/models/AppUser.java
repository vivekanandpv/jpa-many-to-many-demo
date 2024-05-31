package com.example.jpamanytomanydemo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;
    private String username;
    private String email;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    private List<AppUserRole> userRoles = new ArrayList<>();

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AppUserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<AppUserRole> appRoles) {
        this.userRoles = appRoles;
    }
}
