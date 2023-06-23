package org.spring.openai.learn;

import org.spring.openai.learn.config.OpenAIChatCompletionClientConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@AutoConfiguration
@PropertySource("classpath:openai-client-chat-completion-defaults.properties")
@EnableConfigurationProperties(OpenAIChatCompletionClientConfig.class)
public class OpenAIChatCompletionClientAutoConfiguration {
    public OpenAIChatCompletionClientAutoConfiguration() {
        System.out.println("------------- OpenAIChatCompletionClientAutoConfiguration --------------");
    }
}
