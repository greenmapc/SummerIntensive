package com.simbirsoft.taxi_service.repositories;

import com.simbirsoft.taxi_service.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
}
