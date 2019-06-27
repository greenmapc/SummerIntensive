package com.simbirsoft.taxi_service.repository.filters;

import com.simbirsoft.taxi_service.model.Auto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AutoFilter {
    private List<Condition> conditions;


    private Specification<Auto> buildSpecification(Condition condition) {
        switch (condition.getKey()) {
            case "state": {
                condition.setValue(true);
                return buildEqualsSpecifiation(condition);
            }
            case "brand": {
                return buildEqualsSpecifiation(condition);
            }
            case "noarend": {
                condition.setKey("driver");
                return buildIsNullSpecifiation(condition);
            }
        }
        throw new IllegalArgumentException();
    }
    private Specification<Auto> buildEqualsSpecifiation(Condition condition) {
        return new Specification<Auto>() {
            @Override
            public Predicate toPredicate(Root<Auto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(condition.getKey()), condition.getValue());
            }
        };
    }
}
