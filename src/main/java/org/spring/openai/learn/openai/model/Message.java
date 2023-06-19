package org.spring.openai.learn.openai.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Message {
    private String role;
    private String content;
}
