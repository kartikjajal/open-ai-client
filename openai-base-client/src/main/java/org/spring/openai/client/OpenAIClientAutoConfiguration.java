package org.spring.openai.client;

import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@AutoConfiguration
@PropertySource("classpath:openai-client-defaults.properties")
@EnableConfigurationProperties(OpenAIConfig.class)
public class OpenAIClientAutoConfiguration {
}
