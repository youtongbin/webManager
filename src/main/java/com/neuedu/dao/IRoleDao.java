package com.neuedu.dao;

import com.neuedu.pojo.Role;

import java.util.List;

public interface IRoleDao {
    List<Role> getLists();
    int add(Role role);
    Role getOne(Integer id);
    Role getOne(String roleName);
}
