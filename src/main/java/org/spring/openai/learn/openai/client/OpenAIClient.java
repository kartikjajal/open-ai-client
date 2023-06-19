package org.spring.openai.learn.openai.client;

import lombok.Builder;
import org.spring.openai.learn.openai.config.OpenAIConfig;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
public class OpenAIClient {

    @Autowired
    private OpenAIConfig config;



}
