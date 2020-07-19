package com.urumuqi.authservice.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @ClassName CustomUser
 * @Description todo
 * @Author wuqi
 * @Date 2020/7/10 17:16
 **/
public class CustomUser extends User {

    public CustomUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getGrantedAuthorities());
    }
}
