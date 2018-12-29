package com.neuedu.dao;

import com.neuedu.pojo.Role;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDao implements IRoleDao {
    @Override
    public List<Role> getLists() {
        return JdbcUtil.executeQuery("select * from role", new RowMap<Role>() {
            @Override
            public Role RowMapping(ResultSet rs) {
                Role r = new Role();
                try {
                    r.setId(rs.getInt("id"));
                    r.setRoleName(rs.getString("role_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return r;
            }
        });
    }

    @Override
    public int add(Role role) {
        return JdbcUtil.executeUpdate("insert into role(role_name) values (?)",role.getRoleName());
    }

    @Override
    public Role getOne(Integer id) {
        return JdbcUtil.getOne("select * from role where id=?", new RowMap<Role>() {
            @Override
            public Role RowMapping(ResultSet rs) {
                Role r = new Role();
                try {
                    r.setId(rs.getInt("id"));
                    r.setRoleName(rs.getString("role_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return r;
            }
        },id);
    }

    @Override
    public Role getOne(String roleName) {
        return JdbcUtil.getOne("select * from role where role_name=?", new RowMap<Role>() {
            @Override
            public Role RowMapping(ResultSet rs) {
                Role r = new Role();
                try {
                    r.setId(rs.getInt("id"));
                    r.setRoleName(rs.getString("role_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return r;
            }
        },roleName);
    }

}
