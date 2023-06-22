package org.spring.openai.learn;

import org.spring.openai.learn.config.OpenAIChatCompletionClientConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@AutoConfiguration
@PropertySource("classpath:openai-client-chat-completion-defaults.properties")
@EnableConfigurationProperties(OpenAIChatCompletionClientConfig.class)
public class OpenAIChatCompletionClientAutoConfiguration {
}
