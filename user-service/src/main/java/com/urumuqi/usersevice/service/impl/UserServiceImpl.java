package com.urumuqi.usersevice.service.impl;

import com.urumuqi.usersevice.request.UserReq;
import com.urumuqi.usersevice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getUser(Integer userId) {
        return "ok, U got me!!";
    }

    @Override
    public String insert(UserReq user) {
        return "ok, request body : " + user.toString();
    }
}
