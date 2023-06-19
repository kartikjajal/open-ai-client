package org.spring.openai.client.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "openai")
@Validated
@Data
public class OpenAIConfig {
    @NotBlank
    @NotNull
    private String serverUrl;

    @NotBlank
    @NotNull
    private String key;

    @NotBlank
    @NotNull
    private String model;
}
