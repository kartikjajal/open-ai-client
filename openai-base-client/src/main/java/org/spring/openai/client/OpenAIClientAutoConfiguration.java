package org.spring.openai.client;

import org.spring.openai.client.config.OpenAIBaseClientConfig;
import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@AutoConfiguration
@PropertySource("classpath:openai-client-defaults.properties")
@Import({OpenAIConfig.class, OpenAIBaseClientConfig.class})
public class OpenAIClientAutoConfiguration {
    public OpenAIClientAutoConfiguration() {
        System.out.println("--------------------- OpenAIClientAutoConfiguration ---------------------");
    }
}
