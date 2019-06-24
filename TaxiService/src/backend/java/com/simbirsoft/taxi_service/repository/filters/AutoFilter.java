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

    public Specification getComplexSpecification(Root<Auto> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = buildPredicates(root,criteriaQuery,criteriaBuilder);
        Specification<Auto> result = new StubSpecification(predicates.get(0));
        for (int i = 1; i < predicates.size();i++) {
            result= Specification.where(new StubSpecification(predicates.get(0))).and(new StubSpecification(predicates.get(i)));

        }
        return result;
    }

    private List<Predicate> buildPredicates(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach(condition -> predicates.add(buildPredicate(condition, root, criteriaQuery, criteriaBuilder)));
        return predicates;
    }

    public Predicate buildPredicate(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (condition.getKey()) {
            case "state": {
                return buildIsTruePredicateToCriteria(condition,root,criteriaQuery,criteriaBuilder);
            }
            case "brand": {
                return buildEqualsPredicateToCriteria(condition,root,criteriaQuery,criteriaBuilder);
            }
        }
        throw new IllegalArgumentException();
    }

    private Predicate buildEqualsPredicateToCriteria(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(condition.getKey()), condition.getValue());
    }

    private Predicate buildIsTruePredicateToCriteria(Condition condition, Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(condition.getKey()),true);
    }
}
