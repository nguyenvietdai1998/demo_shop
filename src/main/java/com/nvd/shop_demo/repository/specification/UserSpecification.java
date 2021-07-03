package com.nvd.shop_demo.repository.specification;

import com.nvd.shop_demo.entity.User;
import com.nvd.shop_demo.model.request.user.UserFilterRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    public static Specification<User> filter(UserFilterRequest userFilterRequest) {
        return Specification.where(withUserNameLike(userFilterRequest.getUserName()))
                .and(withAddress(userFilterRequest.getAddress()));
    }

    public static Specification<User> withUserName(String userName) {
        if (StringUtils.isBlank(userName)) return null;
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), userName);

    }

    public static Specification<User> withPassword(String password) {
        if (StringUtils.isBlank(password)) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("password"), password);
    }

    public static Specification<User> withUserNameLike(String userName) {
        if (StringUtils.isBlank(userName)) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("userName"), "%" + userName + "%");
    }

    public static Specification<User> withAddress(String address) {
        if (StringUtils.isBlank(address)) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("address"), address);
    }
}
