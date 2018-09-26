package com.dzc.learn.springcloud.controller;

import com.dzc.learn.springcloud.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration; // 服务注册


    @GetMapping(value = "/hello")
    public String index() {
        List<ServiceInstance> instances = client.getInstances(registration.getServiceId());
        instances.forEach(i -> {
            log.info("/hello, host: {}, service_id:{}", i.getHost(), i.getServiceId());
        });

        return "Hello World";
    }


    @GetMapping("/hello1")
    public String hello(@RequestParam String name) {
        return "Hello" + name;
    }


    @GetMapping("/hello2")
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("/hello3")
    public String hello(@RequestBody User user) {
        return "hello" + user.getName() + "," + user.getAge();
    }
}
