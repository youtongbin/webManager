package com.neuedu.dao;

import com.neuedu.pojo.UserRole;

import java.util.List;

public interface IUserRoleDao {
    List<UserRole> getLists(Integer userId);
    int add(Integer userId,Integer roleId);
}
