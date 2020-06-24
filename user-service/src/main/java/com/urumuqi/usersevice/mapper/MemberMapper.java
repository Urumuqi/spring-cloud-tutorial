package com.urumuqi.usersevice.mapper;

import com.urumuqi.usersevice.model.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(String guid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}