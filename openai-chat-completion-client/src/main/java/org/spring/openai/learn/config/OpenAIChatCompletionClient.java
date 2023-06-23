package org.spring.openai.learn.config;

import org.spring.openai.client.config.OpenAIBaseClient;
import org.spring.openai.client.config.OpenAIConfig;
import org.spring.openai.learn.model.ChatCompletionRequest;
import org.spring.openai.learn.model.ChatCompletionResponse;
import org.spring.openai.learn.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class OpenAIChatCompletionClient {

    @Autowired
    private OpenAIChatCompletionClientConfig chatCompletionClientConfig;

    @Autowired
    private OpenAIConfig openAIConfig;

    @Autowired
    @OpenAIBaseClient
    private WebClient.Builder builder;

    public ChatCompletionResponse completeChat(String term) {

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .n(chatCompletionClientConfig.getNumberOfOptions())
                .temperature(chatCompletionClientConfig.getTemperature())
                .model(openAIConfig.getModel())
                .messages(List
                        .of(Message.builder()
                                   .content(term)
                                   .role(chatCompletionClientConfig
                                           .getRole())
                                   .build()))
                .build();

        return builder.build()
                      .post()
                      .uri(chatCompletionClientConfig.getUri())
                      .bodyValue(chatCompletionRequest)
                      .retrieve()
                      .bodyToMono(ChatCompletionResponse.class)
                      .block();
    }
}
