package org.spring.openai.learn.openai.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ChatRequest {
    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;
}
