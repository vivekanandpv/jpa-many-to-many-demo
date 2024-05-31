package com.example.jpamanytomanydemo.models;

import java.io.Serializable;
import java.util.Objects;

public class AppUserRoleKey implements Serializable {
    private int appUserId;
    private int appRoleId;

    public AppUserRoleKey() {
    }

    public AppUserRoleKey(int appUserId, int appRoleId) {
        this.appUserId = appUserId;
        this.appRoleId = appRoleId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUserRoleKey that = (AppUserRoleKey) o;
        return appUserId == that.appUserId && appRoleId == that.appRoleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, appRoleId);
    }
}
