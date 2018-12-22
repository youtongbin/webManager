package com.neuedu.dao;

import com.neuedu.pojo.RoleFunction;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleFunctionDaoImpl  implements IRoleFunctionDao{
    @Override
    public List<RoleFunction> getLists(Integer roleId) {
        return JdbcUtil.executeQuery("select * from role_function where role_id=? order by function_id desc", new RowMap<RoleFunction>() {
            @Override
            public RoleFunction RowMapping(ResultSet rs) {
                RoleFunction rf = new RoleFunction();
                try {
                    rf.setId(rs.getInt("id"));
                    rf.setRoleId(rs.getInt("role_id"));
                    rf.setFunctionId(rs.getInt("function_id"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return rf;
            }
        }, roleId);
    }
}
