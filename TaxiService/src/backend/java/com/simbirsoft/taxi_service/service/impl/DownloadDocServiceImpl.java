package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.dto.DownloadFileDto;
import com.simbirsoft.taxi_service.service.DownloadDocService;
import com.simbirsoft.taxi_service.util.download.MediaTypeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@RequiredArgsConstructor
public class DownloadDocServiceImpl implements DownloadDocService {
    private final ServletContext servletContext;

    @Value("${pdf.store}")
    private String PDF_STORE;

    @Value("${docs.store}")
    private String DOC_STORE;

    @Override
    public DownloadFileDto downloadPdf(String fileName) throws FileNotFoundException {
        return dtoCreation(fileName, PDF_STORE);
    }

    @Override
    public DownloadFileDto downloadDoc(String fileName) throws FileNotFoundException {
        return dtoCreation(fileName, DOC_STORE);
    }

    private DownloadFileDto dtoCreation(String fileName, String path) throws FileNotFoundException {
        DownloadFileDto dto = new DownloadFileDto();
        MediaType mediaType = MediaTypeUtil.getMediaTypeForFileName(servletContext, fileName);
        File file = new File(path + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        dto.setFile(file);
        dto.setIsr(resource);
        dto.setMediaType(mediaType);

        return dto;
    }
}
