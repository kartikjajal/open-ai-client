package org.spring.openai.learn.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openai.chat-completion")
@Getter
@Setter
public class OpenAIChatCompletionClientConfig {

    @NotNull
    @NotBlank
    private String uri;

    @NotNull
    private Integer numberOfOptions;

    @NotNull
    private Double temperature;

    @NotNull
    @NotBlank
    private String role;
}
