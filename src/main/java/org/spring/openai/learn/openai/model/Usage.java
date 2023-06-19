package org.spring.openai.learn.openai.model;

import lombok.Data;

@Data
public class Usage {
    private Long prompt_tokens;
    private Long completion_tokens;
    private Long total_tokens;
}
