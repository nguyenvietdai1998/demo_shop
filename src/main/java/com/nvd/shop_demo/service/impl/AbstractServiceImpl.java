package com.nvd.shop_demo.service.impl;

import com.nvd.shop_demo.model.response.PageResponse;
import com.nvd.shop_demo.repository.BaseRepository;
import com.nvd.shop_demo.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractServiceImpl<T, ID> implements BaseService<T, ID> {

    protected final BaseRepository baseRepository;

    public AbstractServiceImpl(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public <RQ> void save(RQ request, Function<RQ, T> transform) {
        T t = transform.apply(request);
        baseRepository.save(t);
    }

    @Override
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public <RP> RP findById(ID id, Function<T, RP> transform) {
        Optional<T> t = baseRepository.findById(id);

        t.orElseThrow(() -> new RuntimeException());

        return transform.apply(t.get());
    }

    @Override
    public <RP> PageResponse<RP> find(Specification<T> filter, Pageable pageable, Function<T, RP> transform) {
        Page<T> page = baseRepository.findAll(filter, pageable.previousOrFirst());
        List<RP> data = page.stream().map(transform::apply).collect(Collectors.toList());
        return PageResponse.of(page.getTotalElements(), data);
    }

    @Override
    public <RP> List<RP> filter(Specification<T> filter, Function<T, RP> transform) {
        List<T> list = baseRepository.findAll(filter);
        return list.stream().map(transform::apply).collect(Collectors.toList());
    }
}
