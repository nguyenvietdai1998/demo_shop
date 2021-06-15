package com.nvd.shop_demo.service;

import com.nvd.shop_demo.model.response.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.function.Function;

public interface BaseService<T, ID> {

    <RQ> void save(RQ request, Function<RQ, T> transform);

    void delete(ID id);

    <RP> RP findById(ID id, Function<T, RP> transform);

    <RP> PageResponse<RP> find(Specification<T> filter, Pageable pageable, Function<T, RP> transform);

    <RP> List<RP> filter(Specification<T> filter, Function<T, RP> transform);
}
