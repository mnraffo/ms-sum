package com.tenpo.sum.config.apis.fee;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apis.fee")
public class FeeConfigurationProperties {

    private String baseUrl;
    private String feeUri;
    private int connectionTimeout;
    private long responseTimeout;

    public FeeConfigurationProperties() {
    }

    public FeeConfigurationProperties(String baseUrl, String feeUri, int connectionTimeout, long responseTimeout) {
        this.baseUrl = baseUrl;
        this.feeUri = feeUri;
        this.connectionTimeout = connectionTimeout;
        this.responseTimeout = responseTimeout;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getFeeUri() {
        return feeUri;
    }

    public void setFeeUri(String feeUri) {
        this.feeUri = feeUri;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public long getResponseTimeout() {
        return responseTimeout;
    }

    public void setResponseTimeout(long responseTimeout) {
        this.responseTimeout = responseTimeout;
    }
}
