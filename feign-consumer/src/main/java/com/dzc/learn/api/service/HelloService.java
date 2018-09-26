package com.dzc.learn.api.service;

import com.dzc.learn.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    /**
     * 注意 RequestParam, RequestHeader 可以指定参数名称的注解， value 一定要有
     * @param name
     * @return
     */
    @GetMapping("/hello1")
    String hello(@RequestParam("name") String name);

    @GetMapping("/hello2")
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @PostMapping("/hello3")
    String hello(@RequestBody User user);
}
