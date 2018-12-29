package com.neuedu.dao;

import com.neuedu.pojo.UserRole;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRoleDaoImpl implements IUserRoleDao {

    @Override
    public List<UserRole> getLists(Integer userId) {
        return JdbcUtil.executeQuery("select * from user_role where user_id=? order by role_id desc", new RowMap<UserRole>() {
            @Override
            public UserRole RowMapping(ResultSet rs) {
                UserRole ur = new UserRole();
                try {
                    ur.setId(rs.getInt("id"));
                    ur.setUserId(rs.getInt("user_id"));
                    ur.setRoleId(rs.getInt("role_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return ur;
            }
        }, userId);
    }

    @Override
    public int add(Integer userId,Integer roleId) {
        return JdbcUtil.executeUpdate("insert into user_role(user_id,role_id) values (?,?)",userId,roleId);
    }

    @Override
    public int delete(Integer userId, Integer roleId) {
        return JdbcUtil.executeUpdate("delete from user_role where user_id=? and role_id=?",userId,roleId);
    }

    @Override
    public int delete(Integer userId) {
        return JdbcUtil.executeUpdate("delete from user_role where user_id=?",userId);
    }
}
