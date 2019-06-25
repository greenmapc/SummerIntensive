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

    @Override
    public DownloadFileDto downloadPdf(String fileName) throws FileNotFoundException {
        DownloadFileDto dto = new DownloadFileDto();
        MediaType mediaType = MediaTypeUtil.getMediaTypeForFileName(servletContext, fileName);
        File file = new File(PDF_STORE + "/" + fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        dto.setFile(file);
        dto.setIsr(resource);
        dto.setMediaType(mediaType);

        return dto;
    }
}
