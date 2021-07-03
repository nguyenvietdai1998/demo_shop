package com.nvd.shop_demo.controller;

import com.nvd.shop_demo.mapper.UserMapper;
import com.nvd.shop_demo.model.request.user.UserFilterRequest;
import com.nvd.shop_demo.model.request.user.UserSaveRequest;
import com.nvd.shop_demo.model.response.BaseResponse;
import com.nvd.shop_demo.repository.specification.UserSpecification;
import com.nvd.shop_demo.service.UserService;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Data
public class UserController extends BaseController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/user")
    public ResponseEntity<BaseResponse> save(@RequestBody UserSaveRequest userSaveRequest) {
        userService.save(userSaveRequest, userMapper::mapToEntity);

        return success();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable long id) {
        userService.delete(id);

        return success();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable long id) {

        return success(userService.findById(id, userMapper::mapToRespones));
    }

    @GetMapping("/users")
    public ResponseEntity<BaseResponse> findAll(@ModelAttribute UserFilterRequest filterRequest) {
        PageRequest pageRequest = PageRequest.of(filterRequest.getIndex(), filterRequest.getSize(), Sort.by("id").descending());
        return success(userService.find(UserSpecification.filter(filterRequest), pageRequest, userMapper::mapToRespones));
    }

}
