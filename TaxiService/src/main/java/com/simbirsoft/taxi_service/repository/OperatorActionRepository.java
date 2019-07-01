package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.OperatorAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorActionRepository extends JpaRepository<OperatorAction, Long> {
}
