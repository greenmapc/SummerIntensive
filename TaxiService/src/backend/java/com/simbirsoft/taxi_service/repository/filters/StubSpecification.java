package com.simbirsoft.taxi_service.repository.filters;

import com.simbirsoft.taxi_service.model.Auto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StubSpecification implements Specification<Auto> {
    Predicate predicate;

    @Override
    public Predicate toPredicate(Root<Auto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return predicate;
    }
}
