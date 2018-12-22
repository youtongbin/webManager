package com.neuedu.dao;

import com.neuedu.pojo.Function;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionDaoImpl implements IFunctionDao {
    @Override
    public Function getOne(Integer functionId) {
        return JdbcUtil.getOne("select * from function where id=?", new RowMap<Function>() {
            @Override
            public Function RowMapping(ResultSet rs) {
                Function f = new Function();
                try {
                    f.setId(rs.getInt("id"));
                    f.setUrl(rs.getString("url"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return f;
            }
        }, functionId);
    }
}
