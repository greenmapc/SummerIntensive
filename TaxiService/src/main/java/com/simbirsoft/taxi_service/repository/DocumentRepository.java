package com.simbirsoft.taxi_service.repository;

import com.simbirsoft.taxi_service.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
