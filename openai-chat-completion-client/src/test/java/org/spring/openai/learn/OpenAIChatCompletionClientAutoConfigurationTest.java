package org.spring.openai.learn;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.openai.client.OpenAIClientAutoConfiguration;
import org.spring.openai.learn.config.OpenAIChatCompletionClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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
class OpenAIChatCompletionClientAutoConfigurationTest {

    @Autowired
    private OpenAIChatCompletionClientConfig subject;

    @Test
    void test_successful_autoconfigured() {
        new ApplicationContextRunner()
                .withUserConfiguration(
                        OpenAIChatCompletionClientAutoConfiguration.class,
                        OpenAIClientAutoConfiguration.class)
                .run((context) -> {
                    Assertions.assertThat(context)
                              .hasSingleBean(OpenAIChatCompletionClientAutoConfiguration.class);
                });
    }
}
