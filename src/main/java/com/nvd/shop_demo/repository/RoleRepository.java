package com.nvd.shop_demo.repository;

import com.nvd.shop_demo.entity.Role;

import java.util.List;

public interface RoleRepository extends BaseRepository<Role, Long> {
    List<Role> findAllByIdIn(List<Long> ids);
    
}
