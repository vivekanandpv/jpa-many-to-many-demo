package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.viewmodels.AppRoleCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppRoleViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleServiceImplementation implements AppRoleService {
    @Override
    public List<AppRoleViewModel> get() {
        return List.of();
    }

    @Override
    public AppRoleViewModel create(AppRoleCreateViewModel viewModel) {
        return null;
    }
}
