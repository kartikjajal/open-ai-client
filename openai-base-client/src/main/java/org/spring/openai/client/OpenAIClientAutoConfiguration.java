package org.spring.openai.client;

import org.spring.openai.client.config.OpenAIBaseClientConfig;
import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@AutoConfiguration
@PropertySource("classpath:openai-client-defaults.properties")
@EnableConfigurationProperties({OpenAIConfig.class})
@ComponentScan
public class OpenAIClientAutoConfiguration {

}
