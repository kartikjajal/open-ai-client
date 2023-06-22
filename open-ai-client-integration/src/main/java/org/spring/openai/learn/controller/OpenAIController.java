package org.spring.openai.learn.controller;

import org.spring.openai.learn.client.OpenAIChatCompletionClient;
import org.spring.openai.learn.model.ChatCompletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAIController {

    @Autowired
    private OpenAIChatCompletionClient chatCompletionClient;

    @PostMapping("/search")
    public ChatCompletionResponse completeChat(@RequestParam("term") String term) {
        return chatCompletionClient.completeChat(term);
    }
}
