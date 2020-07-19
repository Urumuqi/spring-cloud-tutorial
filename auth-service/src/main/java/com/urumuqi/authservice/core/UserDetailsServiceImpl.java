package com.urumuqi.authservice.core;

import com.urumuqi.authservice.Model.CustomUser;
import com.urumuqi.authservice.Model.UserEntity;
import com.urumuqi.authservice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义用户验证类.
 *
 * @author wuqi <wuqi226@gmail.com>
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getUserDetails(username);
        return new CustomUser(userEntity);
    }
}
