package com.nvd.shop_demo.validate;

import com.nvd.shop_demo.exception.ValidateException;
import com.nvd.shop_demo.model.request.user.UserSaveRequest;
import org.apache.commons.lang3.StringUtils;

public class UserValidate {
    public static UserSaveRequest validate(UserSaveRequest userSaveRequest) {
        return Validator.of(userSaveRequest, () -> new ValidateException("Object not null"))
                .validate(UserSaveRequest::getUserName, UserValidate::validUserName, () -> new ValidateException("user valid username"))
                .validate(UserSaveRequest::getPassword, UserValidate::validPassword, () -> new ValidateException("user valid password"))
                .validate(UserSaveRequest::getAddress, UserValidate::validAddress, () -> new ValidateException("user valid addressx"))
                .get();
    }

    private static boolean validUserName(String userName) {
        return StringUtils.isBlank(userName);
    }

    private static boolean validPassword(String password) {
        return StringUtils.isBlank(password);
    }

    private static boolean validAddress(String address) {
        return StringUtils.isBlank(address);
    }

}
