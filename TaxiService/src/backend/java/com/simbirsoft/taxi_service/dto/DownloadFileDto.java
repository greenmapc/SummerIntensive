package com.simbirsoft.taxi_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;

import java.io.File;

@NoArgsConstructor
@Data
public class DownloadFileDto {
    private MediaType mediaType;
    private InputStreamResource isr;
    private File file;
}
