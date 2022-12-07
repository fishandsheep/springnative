package com.example.springnative.contoller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NativeController {


    @RequestMapping("/native")
    public Object github() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build().getForObject("https://api.bilibili.com/x/web-interface/nav", Object.class);
    }

}
