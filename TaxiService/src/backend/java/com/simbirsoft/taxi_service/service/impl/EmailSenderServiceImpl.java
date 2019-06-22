package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Override
    public void sendMessage(String subject, String text, String mailTo) {
        MimeMessagePreparator messagePreparator = mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
            messageHelper.setFrom(mailFrom);
            messageHelper.setTo(mailTo);
        };

        // Exception without net
        javaMailSender.send(messagePreparator);
    }
}
