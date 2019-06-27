package com.simbirsoft.taxi_service.repository.filters;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SpecificatiomBuilder<T> {
    private List<Condition> conditions;

    public Specification getComplexSpecification() {
        List<Specification<T>> specifications= buildSpecifications();
        Specification<T> result = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }

    private List<Specification<T>> buildSpecifications() {
        List<Specification<T>> specifications = new ArrayList<>();
        conditions.forEach(condition -> specifications.add(buildSpecification(condition)));
        return specifications;
    }

    public Specification<T> buildEqualsSpecifiation(Condition condition) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(condition.getKey()), condition.getValue());
            }
        };
    }

    public Specification<T> buildIsNullSpecifiation(Condition condition) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNull(root.get(condition.getKey()));
            }
        };
    }
}

