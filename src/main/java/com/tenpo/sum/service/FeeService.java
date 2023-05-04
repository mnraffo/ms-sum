package com.tenpo.sum.service;

import com.tenpo.sum.client.fee.FeeClient;
import com.tenpo.sum.dto.Fee;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

    @Autowired
    private FeeClient feeClient;

    @Cacheable("${apis.fee.cache.fee-key}")
    @Retry(name = "feeServiceRetry")
    public Fee getFee() {
        return feeClient.getFee();
    }
}
