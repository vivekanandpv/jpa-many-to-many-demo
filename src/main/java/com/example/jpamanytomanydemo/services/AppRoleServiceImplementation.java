package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.models.AppRole;
import com.example.jpamanytomanydemo.repositories.AppRoleRepository;
import com.example.jpamanytomanydemo.viewmodels.AppRoleCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppRoleViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppRoleServiceImplementation implements AppRoleService {
    private final AppRoleRepository roleRepository;

    public AppRoleServiceImplementation(AppRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<AppRoleViewModel> get() {
        return
                roleRepository
                        .findAll()
                        .stream()
                        .map(this::toVideModel)
                        .collect(Collectors.toList());
    }

    @Override
    public AppRoleViewModel create(AppRoleCreateViewModel viewModel) {
        return toVideModel(roleRepository.saveAndFlush(toEntity(viewModel)));
    }

    private AppRoleViewModel toVideModel(AppRole entity) {
        AppRoleViewModel viewModel = new AppRoleViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private AppRole toEntity(AppRoleCreateViewModel viewModel) {
        AppRole entity = new AppRole();
        BeanUtils.copyProperties(viewModel, entity);
        return entity;
    }
}
