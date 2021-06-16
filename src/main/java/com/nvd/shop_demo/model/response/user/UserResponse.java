package com.nvd.shop_demo.model.response.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private LocalDate dateOfBirth;
}
