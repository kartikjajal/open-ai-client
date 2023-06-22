package org.spring.openai.learn.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String role;
    private String content;
}

