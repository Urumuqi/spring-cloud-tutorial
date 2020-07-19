package com.urumuqi.authservice.dao;

import com.urumuqi.authservice.Model.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName UserDao
 * @Description todo
 * @Author wuqi
 * @Date 2020/7/10 17:20
 **/
@Repository
public class UserDao {

    /**
     * 通过用户名获取用户信息.
     *
     * @param username
     *
     * @return UserEntity
     */
    public UserEntity getUserDetails(String username) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        UserEntity user = new UserEntity();
        user.setUsername("user");
        user.setPassword("password");

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
        grantedAuthorities.add(grantedAuthority);

        user.setGrantedAuthorities(grantedAuthorities);

        return user;
    }
}
