package org.spring.openai.learn.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIBaseClientConfig;
import org.spring.openai.client.config.OpenAIConfig;
import org.spring.openai.learn.OpenAIChatCompletionClientAutoConfiguration;
import org.spring.openai.learn.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        OpenAIConfig.class,
        OpenAIBaseClientConfig.class
})
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class,
        OpenAIChatCompletionClientAutoConfiguration.class
})
@TestPropertySource(properties = {
        "openai.server-url: http://localhost:9898",
        "openai.chat-completion.uri=test-uri",
        "openai.chat-completion.number-of-options=1",
        "openai.chat-completion.temperature=0.2",
        "openai.chat-completion.role=system"
})
@WireMockTest(httpPort = 9898)
class OpenAIChatCompletionClientTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private OpenAIChatCompletionClient chatCompletionClient;
    @Value("classpath:chat-completion-response.json")
    private Resource expectedResource;

    @Test
    @SneakyThrows
    void test_completeChat() {

        ChatCompletionResponse expected = objectMapper
                .readValue(expectedResource.getInputStream(), ChatCompletionResponse.class);
        WireMock.stubFor(WireMock.post("/test-uri")
                                 .willReturn(ResponseDefinitionBuilder.okForJson(expected)));
        ChatCompletionResponse actual = chatCompletionClient.completeChat("hi to openai");
        Assertions.assertThat(actual)
                  .usingRecursiveComparison()
                  .isEqualTo(expected);
    }
}
