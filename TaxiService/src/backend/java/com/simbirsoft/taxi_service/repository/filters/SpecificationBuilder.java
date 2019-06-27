package com.simbirsoft.taxi_service.repository.filters;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.repository.filters.strategy.AutoTransStrategy;
import com.simbirsoft.taxi_service.repository.filters.strategy.DriverTransStrategy;
import com.simbirsoft.taxi_service.repository.filters.strategy.TransCondToSpecStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class SpecificationBuilder<T> {
    private List<Condition> conditions;

    public Specification getComplexSpecification(Class clazz) {
        TransCondToSpecStrategy<T> strategy = null;
        try {
            strategy = (TransCondToSpecStrategy) Class.forName(TransCondToSpecStrategy.class.getPackage().getName() + "."
                    + clazz.getSimpleName() + "TransStrategy").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Class is not supported", e);
        }
        List<Specification<T>> specifications = buildSpecifications(strategy);
        Specification<T> result = specifications.get(0);
        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }

    private List<Specification<T>> buildSpecifications(TransCondToSpecStrategy<T> strategy) {
        List<Specification<T>> specifications = new ArrayList<>();
        conditions.forEach(condition -> specifications.add(strategy.transform(condition, this)));
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

