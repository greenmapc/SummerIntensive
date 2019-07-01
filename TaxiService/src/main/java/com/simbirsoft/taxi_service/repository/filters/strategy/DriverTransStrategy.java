package com.simbirsoft.taxi_service.repository.filters.strategy;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.repository.filters.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

public class DriverTransStrategy implements TransCondToSpecStrategy<Driver> {
    @Override
    public Specification<Driver> transform(Condition condition, SpecificationBuilder<Driver> builder) {
        switch (condition.getKey()) {
            case "rating": {
                condition.setValue(Integer.parseInt((String)condition.getValue()));
                return builder.buildEqualsSpecifiation(condition);
            }
            case "banned": {
                condition.setKey("blackList");
                condition.setValue(true);
                return builder.buildEqualsSpecifiation(condition);
            }

        }
        throw new IllegalArgumentException();
    }
}
