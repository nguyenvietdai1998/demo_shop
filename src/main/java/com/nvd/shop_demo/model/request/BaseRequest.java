package com.nvd.shop_demo.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {
    private int index = 1;
    private int size = 10;
}
