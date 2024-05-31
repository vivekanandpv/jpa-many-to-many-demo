package com.example.jpamanytomanydemo.apis;

import com.example.jpamanytomanydemo.services.AppRoleService;
import com.example.jpamanytomanydemo.viewmodels.AppRoleCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppRoleViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/roles")
public class RoleApi {
    private final AppRoleService roleService;

    public RoleApi(AppRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<AppRoleViewModel>> get() {
        return ResponseEntity.ok(roleService.get());
    }

    @PostMapping
    public ResponseEntity<AppRoleViewModel> create(@RequestBody AppRoleCreateViewModel viewModel) {
        return ResponseEntity.ok(roleService.create(viewModel));
    }
}
