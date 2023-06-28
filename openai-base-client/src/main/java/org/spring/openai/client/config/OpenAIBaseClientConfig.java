package org.spring.openai.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class OpenAIBaseClientConfig {

    @Autowired
    private OpenAIConfig openAIConfig;

    @Bean
    @OpenAIBaseClient
    public WebClient.Builder baseClient() {
        return WebClient.builder()
                        .baseUrl(openAIConfig.getServerUrl())
                        .filter(fillAuthenticationHeader());
    }

    ExchangeFilterFunction fillAuthenticationHeader() {

        return ExchangeFilterFunction.ofRequestProcessor(clientRequest ->
                Mono.just(ClientRequest
                        .from(clientRequest)
                        .header("Authorization", "YOUR_TOKEN")
                        .build()));
    }
}

