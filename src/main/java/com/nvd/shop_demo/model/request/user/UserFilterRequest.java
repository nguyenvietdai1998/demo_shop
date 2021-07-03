package com.nvd.shop_demo.model.request.user;

import com.nvd.shop_demo.model.request.BaseRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilterRequest extends BaseRequest {
    private String userName;
    private String address;
}
