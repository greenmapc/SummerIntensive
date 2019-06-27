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





}
