package com.urumuqi.usersevice.custommapper;

import com.urumuqi.usersevice.dto.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface CustomUserMapper {

    UserInfo selectUserByName(@Param("username") String username);
}
