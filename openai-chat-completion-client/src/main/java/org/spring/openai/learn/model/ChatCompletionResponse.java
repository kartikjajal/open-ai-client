package org.spring.openai.learn.model;

import lombok.Data;

import java.util.List;

@Data
public class ChatCompletionResponse {
    private String id;
    private String object;
    private Long crated;
    private String model;
    private Usage usage;
    private List<Choice> choices;
}
