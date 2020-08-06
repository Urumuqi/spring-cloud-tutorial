package com.urumuqi.usersevice.controller;

import com.urumuqi.usersevice.dto.UserInfo;
import com.urumuqi.usersevice.request.UserReq;
import com.urumuqi.usersevice.service.OrderService;
import com.urumuqi.usersevice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable Integer userId) {
        log.info("GET request: /user/{id}");
        return userService.getUser(userId);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody UserReq user) {
        log.info("POST request : /user");
        return userService.insert(user);
    }

    @GetMapping("/hellofeign")
    public String hello() {
        log.info("get request : /hello");
        return orderService.hello();
    }

    @GetMapping("/user/{username}/info")
    public UserInfo getUserByName(@PathVariable String username) {
        log.info("request getUserByName");
        return null;
    }
}
