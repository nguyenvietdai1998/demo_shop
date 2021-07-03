package com.nvd.shop_demo.controller;

import com.nvd.shop_demo.exception.NotiTemplate;
import com.nvd.shop_demo.model.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    public ResponseEntity<BaseResponse> success() {
        BaseResponse response = new BaseResponse(NotiTemplate.SUCCESS);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<BaseResponse> success(Object object) {
        return ResponseEntity.ok(new BaseResponse(NotiTemplate.SUCCESS, object));
    }
}
