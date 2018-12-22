package com.neuedu.service;

import com.neuedu.pojo.UserRole;

import java.util.List;

public interface IUserRoleService {
    List<UserRole> getLists(Integer userId);
    int add(Integer userId,Integer roleId);
}
