package com.tenpo.sum.client.fee;

import com.tenpo.sum.config.apis.fee.FeeConfigurationProperties;
import com.tenpo.sum.dto.Fee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FeeClient {

    @Autowired
    private FeeConfigurationProperties feeConfigurationProperties;

    @Autowired
    private WebClient feeWebClient;

    public Fee getFee() {
        return feeWebClient
                .get()
                .uri(feeConfigurationProperties.getFeeUri())
                .retrieve()
                .bodyToMono(Fee.class)
                .block();
    }
}
