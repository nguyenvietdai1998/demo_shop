package com.nvd.shop_demo.controller;

import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.service.UserService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Data
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/user")
    public ResponseEntity<Page<User>> findAll(@RequestParam(value = "1") int index,
                                              @RequestParam(value = "10") int size) {
        return ResponseEntity.ok(userService.findAll(PageRequest.of(index, size)));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
