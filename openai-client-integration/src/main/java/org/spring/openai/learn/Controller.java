package org.spring.openai.learn;


import org.spring.openai.learn.client.OpenAIChatCompletionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OpenAIChatCompletionClient openAIChatCompletionClient;

    @GetMapping("/search")
    public String search(@RequestParam("term") String term) {
        return term;
    }
}
