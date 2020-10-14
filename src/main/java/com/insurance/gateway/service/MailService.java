package com.insurance.gateway.service;

import com.insurance.gateway.dto.external.PersonDataDTO;
import com.insurance.gateway.util.LoggingUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Async
    public void sendEmailToCustomer(PersonDataDTO personData) {
        LoggingUtil.logInfo("Email server was called and absolutely nothing happened because it's not implemented");
    }
}
