package com.simbirsoft.taxi_service.repository.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Condition {
    private String key;
    private String operation;
    private Object value;
}
