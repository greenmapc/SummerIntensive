package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>, JpaSpecificationExecutor<Auto> {

    @Query("FROM Auto WHERE id NOT IN (SELECT " +
                "a.auto.id FROM Act as a JOIN a.auto " +
                    "WHERE a.leaseEndDate >= current_timestamp)")
    List<Auto> findAllFree();

}
