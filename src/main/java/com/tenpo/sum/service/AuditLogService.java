package com.tenpo.sum.service;

import com.tenpo.sum.model.AuditLog;
import com.tenpo.sum.repository.AuditLogRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.List;

@Async
@Service
public class AuditLogService {

    @Value("${spring.application.name}")
    private String applicationName;

    private final List<String> auditableUris = List.of(
            "/ms-sum/sum"
    );

    @Autowired
    private AuditLogRepository auditLogRepository;

    public void log(String remoteAddress, String requestMethod, String requestUri,
                    int responseStatus, String requestBody, String responseBody)
            throws UnknownHostException {

        if (!auditableUris.contains(requestUri)) {
            responseBody = "<internal_masked_body>";
        }

        maskUnsafeSensitiveData(responseBody);

        AuditLog auditLog = new AuditLog(
                Instant.now(),
                InetAddress.getLocalHost().getHostName(),
                InetAddress.getLocalHost().getHostAddress(),
                applicationName,
                remoteAddress,
                requestMethod,
                requestUri,
                responseStatus,
                Strings.trimToNull(requestBody),
                responseBody
        );

        auditLogRepository.save(auditLog);
    }

    private void maskUnsafeSensitiveData(String responseBody) {
        // TODO mask sensitive data like janino logback encoder
    }
}
