package org.spring.openai.learn.openai.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.spring.openai.learn.openai.config.OpenAIConfig;
import org.spring.openai.learn.openai.model.ChatCompletionResponse;
import org.spring.openai.learn.openai.model.ChatRequest;
import org.spring.openai.learn.openai.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@Slf4j
public class OpenAIController {

    @Autowired
    private OpenAIConfig config;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/search")
    @SneakyThrows
    public ChatCompletionResponse search(@RequestParam("term") String term){

        ChatRequest chatRequest = ChatRequest.builder()
                .temperature(0.2)
                .model(config.getModel())
                .n(1)
                .messages(List.of(Message.builder()
                        .role("system")
                        .content(term)
                        .build()))
                .build();

         return webClientBuilder
                .baseUrl(config.getServerUrl())
                .build()
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", String.format("Bearer %s", config.getKey()))
                .bodyValue(chatRequest)
                .retrieve()
                .bodyToMono(ChatCompletionResponse.class)
                .block();
    }
}
