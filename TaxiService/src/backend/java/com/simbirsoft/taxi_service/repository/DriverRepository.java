package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("FROM Driver WHERE id NOT IN (" +
            "SELECT act.driverRecipient.id FROM Act as act JOIN act.driverRecipient " +
             "WHERE act.leaseEndDate >= current_timestamp)")
    List<Driver> findAllWithoutRent();

}
