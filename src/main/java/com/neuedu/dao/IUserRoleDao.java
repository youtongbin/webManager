package com.neuedu.dao;

import com.neuedu.pojo.UserRole;

import java.util.List;

public interface IUserRoleDao {
    //根据id一个id对应的角色
    List<UserRole> getLists(Integer userId);
    int add(Integer userId,Integer roleId);
}
