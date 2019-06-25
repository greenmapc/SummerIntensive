
package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Act;

import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Act a SET a.leaseEndDate = current_timestamp " +
            "WHERE a.driverRenter = :driver AND a.leaseEndDate > current_timestamp")
    void setRentEnd(@Param("driver") Driver driver);
}
