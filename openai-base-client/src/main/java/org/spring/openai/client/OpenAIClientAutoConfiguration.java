package org.spring.openai.client;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@EnableAutoConfiguration
@PropertySource("classpath:openai-client-defaults.properties")
public class OpenAIClientAutoConfiguration {
}
