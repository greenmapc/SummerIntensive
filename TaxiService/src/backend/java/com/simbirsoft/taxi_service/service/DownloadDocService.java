package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.dto.DownloadFileDto;

import java.io.FileNotFoundException;

public interface DownloadDocService {
    DownloadFileDto downloadPdf(String fileName) throws FileNotFoundException;
}
