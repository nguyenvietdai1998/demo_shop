package com.nvd.shop_demo.model.request.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UserSaveRequest {
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private LocalDate dateOfBirth;
    private List<Long> ids;
}
