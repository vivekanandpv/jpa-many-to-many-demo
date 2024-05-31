package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.viewmodels.AppUserCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppUserViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImplementation implements AppUserService {
    @Override
    public List<AppUserViewModel> get() {
        return List.of();
    }

    @Override
    public AppUserViewModel create(AppUserCreateViewModel viewModel) {
        return null;
    }
}
