package com.urumuqi.usersevice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-srv")
public interface OrderService {

    @GetMapping("/hello")
    String hello();
}
