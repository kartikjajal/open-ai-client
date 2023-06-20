package org.spring.openai.learn.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        OpenAIConfig.class
})
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class
})
@TestPropertySource(properties = {
        "openai.server-url: https://api.openai.com/v1/chat/completions",
        "openai.key: test-key",
        "openai.model: gpt-3.5-turbo"
})
class OpenAIConfigTest {

    @Autowired
    private OpenAIConfig subject;

    @Test
    void test_config_success() {
        Assertions.assertThat(subject)
                  .isNotNull();

        Assertions.assertThat(subject.getKey())
                  .isEqualTo("test-key");

        Assertions.assertThat(subject.getModel())
                  .isEqualTo("gpt-3.5-turbo");

        Assertions.assertThat(subject.getServerUrl())
                  .isEqualTo("https://api.openai.com/v1/chat/completions");
    }
}
