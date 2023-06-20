package org.spring.openai.learn;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:openai-client-chat-completion-defaults.properties")
public class OpenAIChatCompletionClientAutoConfiguration {
}
