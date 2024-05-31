package com.example.jpamanytomanydemo.viewmodels;

import java.util.HashSet;
import java.util.Set;

public class AppUserViewModel {
    private int appUserId;
    private String username;
    private String email;
    private Set<AppRoleViewModel> roles = new HashSet<>();

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

    public Set<AppRoleViewModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRoleViewModel> roles) {
        this.roles = roles;
    }
}
