package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.viewmodels.AppUserCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppUserViewModel;

import java.util.List;

public interface AppUserService {
    List<AppUserViewModel> get();
    AppUserViewModel create(AppUserCreateViewModel viewModel);
}
