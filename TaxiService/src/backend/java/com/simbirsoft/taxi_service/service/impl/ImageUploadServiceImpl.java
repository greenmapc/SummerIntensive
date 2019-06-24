package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Document;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.repository.DocumentRepository;
import com.simbirsoft.taxi_service.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageUploadServiceImpl implements ImageUploadService {
    private final DocumentRepository documentRepository;

    @Value("${docs.store}")
    private String uploadPath;

    @Override
    public Optional<Document> saveDriverDocument(Driver driver, MultipartFile multipartFile) {
        return Optional.empty();
    }

    @Override
    public Optional<Document> saveAutoDocument(Auto auto, MultipartFile file) throws IOException {
        String fileGenerateName = UUID.randomUUID().toString();
        file = saveFile(file, fileGenerateName);

        Document document = new Document();
        document.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()));
        document.setGeneratedName(fileGenerateName);
        document.setAuto(auto);

        documentRepository.save(document);
        return Optional.of(document);
    }

    private MultipartFile saveFile(MultipartFile file, String newName) throws IOException {

        if (file == null || file.getOriginalFilename().isEmpty()) {
            throw new IOException();
        }
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();UUID.randomUUID().toString();
        }

        String resultFilename = newName + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new File(uploadPath + resultFilename));

        return file;
    }
}
