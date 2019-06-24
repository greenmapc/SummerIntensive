package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.repository.filters.Condition;
import com.simbirsoft.taxi_service.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConditionServiceImpl implements ConditionService {
    @Override
    public List<Condition> getConditionsWithoutOperation(List<String> conditions) {
        List<Condition> result = new ArrayList<>(conditions.size());
        Condition condition;
        String[] items;
        for (String conditionItem : conditions) {
            condition = new Condition();
            items = conditionItem.split("_");
            switch (items.length) {
                case 1: {
                    condition.setKey(items[0]);
                    break;
                }
                case 2: {
                    condition.setKey(items[0]);
                    condition.setValue(items[1]);
                    break;
                }
                case 3: {
                    condition.setKey(items[0]);
                    condition.setValue(items[1]);
                    condition.setOperation(items[2]);
                }
                default: {
                    throw new IllegalArgumentException("not supported");
                }
            }
            result.add(condition);
        }
        return result;
    }
}
