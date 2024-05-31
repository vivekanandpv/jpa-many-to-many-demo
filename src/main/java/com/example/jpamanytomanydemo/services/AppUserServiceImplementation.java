package com.example.jpamanytomanydemo.services;

import com.example.jpamanytomanydemo.exceptions.RecordNotFoundException;
import com.example.jpamanytomanydemo.models.AppRole;
import com.example.jpamanytomanydemo.models.AppUser;
import com.example.jpamanytomanydemo.models.AppUserRole;
import com.example.jpamanytomanydemo.repositories.AppRoleRepository;
import com.example.jpamanytomanydemo.repositories.AppUserRepository;
import com.example.jpamanytomanydemo.repositories.AppUserRoleRepository;
import com.example.jpamanytomanydemo.viewmodels.AppRoleViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppUserCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppUserViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AppUserServiceImplementation implements AppUserService {
    private final AppUserRepository userRepository;
    private final AppRoleRepository roleRepository;
    private final AppUserRoleRepository userRoleRepository;

    public AppUserServiceImplementation(
            AppUserRepository userRepository,
            AppRoleRepository roleRepository,
            AppUserRoleRepository userRoleRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<AppUserViewModel> get() {
        return userRepository
                        .findAll()
                        .stream()
                        .map(this::toViewModel)
                        .collect(Collectors.toList());
    }

    @Override
    public AppUserViewModel create(AppUserCreateViewModel viewModel) {
        AppUser entity = new AppUser();
        BeanUtils.copyProperties(viewModel, entity);

        userRepository.saveAndFlush(entity);

        List<AppUserRole> userRoles = Stream.of(viewModel.getRoles())
                .map(r -> getJoinEntity(entity, getMasterEntity(r)))
                .collect(Collectors.toList());

        userRoleRepository.saveAllAndFlush(userRoles);

        entity.setUserRoles(userRoles);

        return toViewModel(entity);
    }

    private AppUserViewModel toViewModel(AppUser entity) {
        AppUserViewModel viewModel = new AppUserViewModel();
        BeanUtils.copyProperties(entity, viewModel);

        viewModel.setRoles(
                entity
                        .getUserRoles()
                        .stream()
                        .map(ar -> toViewModel(ar.getAppRole()))
                        .collect(Collectors.toSet())
        );

        return viewModel;
    }

    private AppRoleViewModel toViewModel(AppRole entity) {
        AppRoleViewModel viewModel = new AppRoleViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private AppUserRole getJoinEntity(AppUser user, AppRole role) {
        AppUserRole joinEntity = new AppUserRole();
        joinEntity.setAppUser(user);
        joinEntity.setAppUserId(user.getAppUserId());
        joinEntity.setAppRole(role);
        joinEntity.setAppRoleId(role.getAppRoleId());

        return joinEntity;
    }

    private AppRole getMasterEntity(String role) {
        return roleRepository
                .findAll()
                .stream()
                .filter(r -> r.getRole().equals(role))
                .findFirst()
                .orElseThrow(() -> new RecordNotFoundException(String.format("Could not find the role: %s", role)));
    }
}
