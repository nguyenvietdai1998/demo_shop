package com.nvd.shop_demo.service.impl;

import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.repository.BaseRepository;
import com.nvd.shop_demo.repository.UserRepository;
import com.nvd.shop_demo.service.UserService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long> implements UserService {

    public UserServiceImpl(BaseRepository baseRepository) {
        super(baseRepository);
    }

}
