package org.spring.openai.learn;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/search")
    public String search(@RequestParam("term") String term) {
        return term;
    }
}
