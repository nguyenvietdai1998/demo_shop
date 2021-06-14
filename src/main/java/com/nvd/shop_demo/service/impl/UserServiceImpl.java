package com.nvd.shop_demo.service.impl;

import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.repository.UserRepository;
import com.nvd.shop_demo.service.UserService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable.previousOrFirst());
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

}
