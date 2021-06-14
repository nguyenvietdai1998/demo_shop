package com.nvd.shop_demo.service;

import com.nvd.shop_demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user);

    Page<User> findAll(Pageable pageable);

    void delete(long id);
}
