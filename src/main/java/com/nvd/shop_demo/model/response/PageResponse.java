package com.nvd.shop_demo.model.response;

import java.util.List;

public final class PageResponse<T> {
    private long totalItem;
    private List<T> data;

    public PageResponse(final long totalItem,final List<T> data) {
        this.totalItem = totalItem;
        this.data = data;
    }

    public static <T> PageResponse<T> of(final long totalItem,final List<T> data){
        return new PageResponse<>(totalItem, data);
    }

    public long getTotalItem() {
        return totalItem;
    }

    public List<T> getData() {
        return data;
    }
}
