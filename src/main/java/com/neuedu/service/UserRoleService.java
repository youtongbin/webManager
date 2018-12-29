package com.neuedu.service;

import com.neuedu.dao.IUserRoleDao;
import com.neuedu.dao.UserRoleDaoImpl;
import com.neuedu.pojo.UserRole;

import java.util.List;

public class UserRoleService implements IUserRoleService {
    IUserRoleDao userRoleDao = new UserRoleDaoImpl();
    @Override
    public List<UserRole> getLists(Integer userId) {
        return userRoleDao.getLists(userId);
    }

    @Override
    public int add(Integer userId,Integer roleId) {
        return userRoleDao.add(userId,roleId);
    }

    @Override
    public int delete(Integer userId, Integer roleId) {
        return userRoleDao.delete(userId,roleId);
    }

    @Override
    public int delete(Integer userId) {
        return userRoleDao.delete(userId);
    }
}
