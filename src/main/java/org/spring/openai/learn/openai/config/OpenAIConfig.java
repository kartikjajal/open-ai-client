package org.spring.openai.learn.openai.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "openai")
@Validated
public class OpenAIConfig {

    @NotNull
    @NotBlank
    private String serverUrl;

    @NotNull
    @NotBlank
    private String key;

    @NotNull
    @NotBlank
    private String model;
}
