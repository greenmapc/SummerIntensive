package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Document;
import com.simbirsoft.taxi_service.model.Driver;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public interface ImageUploadService {
    Optional<Document> saveDriverDocument(Driver driver, MultipartFile multipartFile) throws IOException;
    Optional<Document> saveAutoDocument(Auto auto, MultipartFile multipartFile) throws IOException;
}
