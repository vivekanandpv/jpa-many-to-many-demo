package com.example.jpamanytomanydemo.models;

import jakarta.persistence.*;

@Entity
@IdClass(AppUserRoleKey.class)
public class AppUserRole {
    @Id
    private int appUserId;

    @Id
    private int appRoleId;

    @ManyToOne
    @JoinColumn(name = "appUserId", insertable = false, updatable = false)
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "appRoleId", insertable = false, updatable = false)
    private AppRole appRole;

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public int getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(int appRoleId) {
        this.appRoleId = appRoleId;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
