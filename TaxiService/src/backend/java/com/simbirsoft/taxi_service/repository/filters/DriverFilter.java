package com.simbirsoft.taxi_service.repository.filters;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
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
public class DriverFilter {
    private List<Condition> conditions;

    public Specification getComplexSpecification() {
        List<Specification<Driver>> specifications= buildSpecifications();
        Specification<Driver> result = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }

    private List<Specification<Driver>> buildSpecifications() {
        List<Specification<Driver>> specifications = new ArrayList<>();
        conditions.forEach(condition -> specifications.add(buildSpecification(condition)));
        return specifications;
    }

    private Specification<Driver> buildSpecification(Condition condition) {
        switch (condition.getKey()) {
            case "rating": {
                condition.setValue(Integer.parseInt((String)condition.getValue()));
                return buildEqualsSpecifiation(condition);
            }
            case "banned": {
                condition.setKey("blackList");
                condition.setValue(true);
                return buildEqualsSpecifiation(condition);
            }

        }
        throw new IllegalArgumentException();
    }

    private Specification<Driver> buildEqualsSpecifiation(Condition condition) {
        return new Specification<Driver>() {
            @Override
            public Predicate toPredicate(Root<Driver> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get(condition.getKey()), condition.getValue());
            }
        };
    }
    private Specification<Driver> buildIsNullSpecifiation(Condition condition) {
        return new Specification<Driver>() {
            @Override
            public Predicate toPredicate(Root<Driver> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.isNull(root.get(condition.getKey()));
            }
        };
    }



}
