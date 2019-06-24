package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.repository.filters.Condition;

import java.util.List;

public interface ConditionService {
    List<Condition> getConditionsWithoutOperation(List<String> conditions);
}
