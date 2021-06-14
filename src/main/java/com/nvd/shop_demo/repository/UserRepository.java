package com.nvd.shop_demo.repository;

import com.nvd.shop_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
