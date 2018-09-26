package com.dzc.learn.controller;

import com.dzc.learn.api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/ribbon-consumer")
    public String helloConsumer() {
        return helloService.helloService();
    }
}
