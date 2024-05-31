package com.example.jpamanytomanydemo.apis;

import com.example.jpamanytomanydemo.exceptions.RecordNotFoundException;
import com.example.jpamanytomanydemo.services.AppUserService;
import com.example.jpamanytomanydemo.viewmodels.AppUserCreateViewModel;
import com.example.jpamanytomanydemo.viewmodels.AppUserViewModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/users")
public class UserApi {
    private final AppUserService userService;

    public UserApi(AppUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<AppUserViewModel>> get() {
        return ResponseEntity.ok(userService.get());
    }

    @PostMapping
    public ResponseEntity<AppUserViewModel> create(@RequestBody AppUserCreateViewModel viewModel) {
        return ResponseEntity.ok(userService.create(viewModel));
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException exception) {
        return ResponseEntity.badRequest().body(Map.of("error", exception.getMessage()));
    }
}
