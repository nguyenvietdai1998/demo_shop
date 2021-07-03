package com.nvd.shop_demo.model.response;

import com.nvd.shop_demo.exception.ResponseStatus;

public final class BaseResponse {
    private final ResponseStatus status;
    private final Object baseData;

    public BaseResponse(final ResponseStatus status) {
        this.status = status;
        this.baseData = null;
    }

    public BaseResponse(final ResponseStatus status, final Object baseData) {
        this.status = status;
        this.baseData = baseData;
    }
}
