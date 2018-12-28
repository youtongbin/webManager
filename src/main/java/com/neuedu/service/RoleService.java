package com.neuedu.service;


import com.neuedu.dao.IRoleDao;
import com.neuedu.dao.RoleDao;
import com.neuedu.pojo.Role;

import java.util.List;

public class RoleService implements IRoleService {
    IRoleDao roleDao = new RoleDao();
    @Override
    public List<Role> getLists() {
        return roleDao.getLists();
    }

    @Override
    public int add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getOne(Integer id) {
        return roleDao.getOne(id);
    }

    @Override
    public Role getOne(String roleName) {
        return roleDao.getOne(roleName);
    }

}
