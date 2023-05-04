package com.tenpo.sum.config.apis.fee;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "apis.fee.cache")
public class FeeCacheConfigurationProperties {

    private String feeKey;
    private int feeTtl;

    public FeeCacheConfigurationProperties() {
    }

    public FeeCacheConfigurationProperties(String feeKey, int feeTtl) {
        this.feeKey = feeKey;
        this.feeTtl = feeTtl;
    }

    public String getFeeKey() {
        return feeKey;
    }

    public void setFeeKey(String feeKey) {
        this.feeKey = feeKey;
    }

    public int getFeeTtl() {
        return feeTtl;
    }

    public void setFeeTtl(int feeTtl) {
        this.feeTtl = feeTtl;
    }
}
