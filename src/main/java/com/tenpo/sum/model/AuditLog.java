package com.tenpo.sum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Instant timestamp;
    private String serverHostName;
    private String serverHostAddress;
    private String applicationName;
    private String remoteAddress;
    private String requestMethod;
    private String requestUri;
    private int responseStatus;
    private String requestBody;
    private String responseBody;

    public AuditLog(Instant timestamp, String serverHostName, String serverHostAddress, String applicationName,
                    String remoteAddress, String requestMethod, String requestUri, int responseStatus,
                    String requestBody, String responseBody) {

        this.timestamp = timestamp;
        this.serverHostName = serverHostName;
        this.serverHostAddress = serverHostAddress;
        this.applicationName = applicationName;
        this.remoteAddress = remoteAddress;
        this.requestMethod = requestMethod;
        this.requestUri = requestUri;
        this.responseStatus = responseStatus;
        this.requestBody = requestBody;
        this.responseBody = responseBody;
    }
}
