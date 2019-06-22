
package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Act;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {
}
