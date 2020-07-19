package com.urumuqi.usersevice.service;

import com.urumuqi.usersevice.request.UserReq;
import org.springframework.web.bind.annotation.*;

public interface UserService {

    @GetMapping("/user/{id}")
    String getUser(@PathVariable Integer userId);

    @PostMapping("/user")
    String insert(@RequestBody UserReq user);
}
