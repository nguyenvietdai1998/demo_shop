package com.nvd.shop_demo.mapper;

import com.nvd.shop_demo.entity.Role;
import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.model.request.user.UserSaveRequest;
import com.nvd.shop_demo.model.response.user.UserResponse;
import com.nvd.shop_demo.repository.RoleRepository;
import com.nvd.shop_demo.utils.BeanUtils;
import com.nvd.shop_demo.validate.UserValidate;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
@Data
public class UserMapper {
    private final RoleRepository roleRepository;

    public User mapToEntity(UserSaveRequest userSaveRequest) {
        UserValidate.validate(userSaveRequest);
        User user = new User();
        BeanUtils.refine(userSaveRequest, user, BeanUtils::copyNonNull);
        List<Role> roles = roleRepository.findAllByIdIn(userSaveRequest.getIds());
        user.setRoles(new HashSet<>(roles));
        return user;
    }

    public UserResponse mapToRespones(User user) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.refine(user, userResponse, BeanUtils::copyNonNull);

        return userResponse;
    }
}
