package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.viewmodels.AppRoleCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppRoleViewModel;

import java.util.List;

public interface AppRoleService {
    List<AppRoleViewModel> get();
    AppRoleViewModel create(AppRoleCreateViewModel viewModel);
}
