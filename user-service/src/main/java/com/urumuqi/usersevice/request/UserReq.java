package com.urumuqi.usersevice.request;

import lombok.Data;

@Data
public class UserReq {
    private String name;
    private Integer id;
    private String email;
}
