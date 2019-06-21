package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
}
