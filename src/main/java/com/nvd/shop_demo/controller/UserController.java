package com.nvd.shop_demo.controller;

import com.nvd.shop_demo.mapper.UserMapper;
import com.nvd.shop_demo.model.request.user.UserSaveRequest;
import com.nvd.shop_demo.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Data
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/user")
    public ResponseEntity<Void> save(@RequestBody UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest, userMapper::mapToEntity);
        return ResponseEntity.ok().build();
    }
}
