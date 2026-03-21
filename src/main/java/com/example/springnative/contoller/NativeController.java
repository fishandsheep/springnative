package com.example.springnative.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class NativeController {

    private final RestClient restClient = RestClient.create();

    @RequestMapping("/native")
    public Object github() {
        return restClient.get()
                .uri("https://api.bilibili.com/x/web-interface/nav")
                .retrieve()
                .body(Object.class);
    }

}
