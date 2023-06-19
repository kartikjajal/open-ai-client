package org.spring.openai.learn.openai.model;

import lombok.Data;

@Data
public class Choice {
    private Long index;
    private Message message;
}
