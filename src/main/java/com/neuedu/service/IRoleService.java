package com.neuedu.service;

import com.neuedu.pojo.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getLists();
    int add(Role role);
    Role getOne(Integer id);
    Role getOne(String roleName);
}
