package com.neuedu.service;

import com.neuedu.pojo.User;

import java.util.List;

public interface IUserService {
    //获取所有用户
    List<User> getLists();
    //获取一个用户
    User getOne(String username);
    //添加用户
    int add(User user);
    //修改信息
    int update(User newInfo);
    //删除用户
    int delete(Integer id);
}
