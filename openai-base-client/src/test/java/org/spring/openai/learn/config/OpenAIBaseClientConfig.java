package org.spring.openai.learn.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIBaseClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(SpringExtension.class)
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class
})

public class OpenAIBaseClientConfig {

    @Autowired
    @OpenAIBaseClient
    private WebClient.Builder builder;

    @Test
    void test_builder_success(){
        builder.build()
                .post()
                .retrieve()
                .bodyToMono(String.class);

    }
}
