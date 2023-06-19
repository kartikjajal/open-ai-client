package org.spring.openai.learn;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class
})
@TestPropertySource(properties = {
        "openai.server-url: https://api.openai.com/v1/chat/completions",
        "openai.key: test-key",
        "openai.model: gpt-3.5-turbo"
})
class OpenAIClientAutoConfigurationTest {

    @Test
    void test_bean_initialized_success() {
        new ApplicationContextRunner()
                .withUserConfiguration(OpenAIClientAutoConfiguration.class)
                .run(context -> {
            Assertions.assertThat(context).hasSingleBean(OpenAIClientAutoConfiguration.class);
        });
    }
}
