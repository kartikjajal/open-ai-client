package org.spring.openai.learn.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.client.config.OpenAIBaseClientConfig;
import org.spring.openai.client.config.OpenAIConfig;
import org.spring.openai.learn.OpenAIChatCompletionClientAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        OpenAIConfig.class,
        OpenAIChatCompletionClientConfig.class,
})
@ImportAutoConfiguration(classes = {
        OpenAIClientAutoConfiguration.class,
        OpenAIChatCompletionClientAutoConfiguration.class
})
@TestPropertySource(properties = {
        "openai.chat-completion.uri=test-uri",
        "openai.chat-completion.number-of-options=1",
        "openai.chat-completion.temperature=0.2",
        "openai.chat-completion.role=system"
})
class OpenAIChatCompletionClientConfigTest {

    @Autowired
    private OpenAIChatCompletionClientConfig subject;

    @Test
    void test_successfully_loaded_properties() {
        assertThat(subject)
                .isNotNull();

        assertThat(subject.getRole())
                .isEqualTo("system");

        assertThat(subject.getUri())
                .isEqualTo("test-uri");

        assertThat(subject.getNumberOfOptions())
                .isEqualTo(1);

        assertThat(subject.getTemperature())
                .isEqualTo(0.2);
    }
}
