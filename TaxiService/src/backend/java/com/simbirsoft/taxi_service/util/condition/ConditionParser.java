package com.simbirsoft.taxi_service.util.condition;

import com.simbirsoft.taxi_service.repository.filters.Condition;

import java.util.List;

public interface ConditionParser {
    List<Condition> getConditions(List<String> conditions);
}
