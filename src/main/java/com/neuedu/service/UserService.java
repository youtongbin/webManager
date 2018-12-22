package com.neuedu.service;

import com.neuedu.dao.IUserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.pojo.User;

import java.util.List;

public class UserService implements IUserService {
    private IUserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getLists() {
        return userDao.getLists();
    }

    @Override
    public User getOne(String username) {
        return userDao.getOne(username);
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }
}