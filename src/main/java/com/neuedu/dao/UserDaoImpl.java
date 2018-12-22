package com.neuedu.dao;

import com.neuedu.pojo.User;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> getLists() {
        return JdbcUtil.executeQuery("select * from user", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        });
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.getOne("select * from user where username=?", new RowMap<User>() {
            @Override
            public User RowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }

    @Override
    public int add(User user) {
        return JdbcUtil.executeUpdate("insert into user(username,password,tele) values (?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }
}
