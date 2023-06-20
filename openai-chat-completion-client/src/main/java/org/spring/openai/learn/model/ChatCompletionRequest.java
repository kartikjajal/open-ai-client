package org.spring.openai.learn.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ChatCompletionRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;
}
