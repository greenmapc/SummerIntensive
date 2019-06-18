package com.simbirsoft.taxi_service.repositories;

import com.simbirsoft.taxi_service.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
}
