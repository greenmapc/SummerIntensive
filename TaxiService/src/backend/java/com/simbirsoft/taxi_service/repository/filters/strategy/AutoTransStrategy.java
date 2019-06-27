package com.simbirsoft.taxi_service.repository.filters.strategy;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.repository.filters.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

public class AutoTransStrategy implements TransCondToSpecStrategy<Auto> {
    @Override
    public Specification<Auto> transform(Condition condition, SpecificationBuilder<Auto> builder) {
        switch (condition.getKey()) {
            case "state": {
                condition.setValue(true);
                return builder.buildEqualsSpecifiation(condition);
            }
            case "brand": {
                return builder.buildEqualsSpecifiation(condition);
            }
            case "noarend": {
                condition.setKey("driver");
                return builder.buildIsNullSpecifiation(condition);
            }
        }
        throw new IllegalArgumentException();
    }
}
