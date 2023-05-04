package com.tenpo.sum.config.webclient;

import com.tenpo.sum.config.apis.fee.FeeConfigurationProperties;
import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfiguration {

    @Autowired
    private FeeConfigurationProperties feeConfigurationProperties;

    @Bean
    @Qualifier("feeHttpClient")
    public HttpClient buildFeeHttpClient() {
        return HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, feeConfigurationProperties.getConnectionTimeout())
                .responseTimeout(Duration.ofMillis(feeConfigurationProperties.getResponseTimeout()));
    }

    @Bean
    public WebClient buildFeeWebClient(@Qualifier("feeHttpClient") HttpClient feeHttpClient) {
        return WebClient
                .builder()
                .clientConnector(new ReactorClientHttpConnector(feeHttpClient))
                .baseUrl(feeConfigurationProperties.getBaseUrl())
                .build();
    }
}
