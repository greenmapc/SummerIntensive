package com.simbirsoft.taxi_service.controller;

import com.simbirsoft.taxi_service.dto.DownloadFileDto;
import com.simbirsoft.taxi_service.service.DownloadDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

@Controller
@RequiredArgsConstructor
public class GetDocController {
    private final DownloadDocService downloadDocService;

    @GetMapping("/download/pdf/{file}")
    public ResponseEntity<InputStreamResource> downloadPdfFile(
            @PathVariable("file") String file) {
        DownloadFileDto dto;
        try {
            dto = downloadDocService.downloadPdf(file);
        } catch (FileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok()
                .contentType(dto.getMediaType())
                .header("Content-Disposition", "attachment; filename=" + file)
                .contentLength(dto.getFile().length())
                .body(dto.getIsr());

    }

    @GetMapping("/show/doc/{file}")
    public ResponseEntity<InputStreamResource> downloadDocFile(
            @PathVariable("file") String file) {
        DownloadFileDto dto;
        try {
            dto = downloadDocService.downloadDoc(file);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(dto.getMediaType())
                .header("Content-Disposition", "inline; filename=" + file)
                .contentLength(dto.getFile().length())
                .body(dto.getIsr());
    }
}
