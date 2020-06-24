package com.urumuqi.usersevice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/")
public class UserController {

    @GetMapping("/index")
    public String index()
    {
        return "hello, spring cloud!";
    }
}
