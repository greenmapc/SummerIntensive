package com.simbirsoft.taxi_service.service;

public interface EmailSenderService {
    void sendMessage(String subject, String text, String email);
}
