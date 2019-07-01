package com.simbirsoft.taxi_service.repository.filters.strategy;

import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.repository.filters.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

public interface TransCondToSpecStrategy<T> {
    Specification<T> transform(Condition condition, SpecificationBuilder<T> specificationBuilder);
}
