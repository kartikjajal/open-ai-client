package org.spring.openai.learn.model;

import lombok.*;

@Data
@Builder
public class Message {
    private String role;
    private String content;
}
