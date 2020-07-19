package com.urumuqi.orderservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@Slf4j
public class OrderController {

    @GetMapping("/hello")
    public String hello()
    {
        log.info("you complete me");
        return "hello, I'm order-srv, U got me!!";
    }
}
