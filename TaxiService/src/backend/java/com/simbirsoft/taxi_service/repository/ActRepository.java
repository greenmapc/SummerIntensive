package com.simbirsoft.taxi_service.repositories;

import com.simbirsoft.taxi_service.models.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {
}
