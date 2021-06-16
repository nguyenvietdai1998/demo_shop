package com.nvd.shop_demo.service.impl;

import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.repository.UserRepository;
import com.nvd.shop_demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long> implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

}
