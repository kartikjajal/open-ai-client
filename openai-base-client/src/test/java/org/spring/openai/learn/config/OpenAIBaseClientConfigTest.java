package org.spring.openai.learn.config;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIBaseClient;
import org.spring.openai.client.config.OpenAIBaseClientConfig;
import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder.okForEmptyJson;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        OpenAIConfig.class
})
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class
})
@WireMockTest(httpPort = 9999)
@TestPropertySource(properties = {
        "openai.server-url: http://localhost:9999",
        "openai.key: test-key",
        "openai.model: gpt-3.5-turbo"
})
public class OpenAIBaseClientConfigTest {

    @Autowired
    @OpenAIBaseClient
    private WebClient.Builder builder;

    @Test
    void test_builder_success() {

        stubFor(WireMock.post("/test")
                        .willReturn(okForEmptyJson()
                                .withBody("Hi")));

        String actual = builder.build()
                               .post()
                               .uri("/test")
                               .retrieve()
                               .bodyToMono(String.class)
                               .block();
        assertThat(actual).isEqualTo("Hi");
    }
}
