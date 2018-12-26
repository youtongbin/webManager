package com.neuedu.dao;

import com.neuedu.pojo.Brand;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BrandDao implements IBrandDao {
    @Override
    public List<Brand> getLists() {
        return JdbcUtil.executeQuery("select * from brand", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet rs) {
                Brand brand = new Brand();
                try {
                    brand.setId(rs.getInt("id"));
                    brand.setBrandName(rs.getString("brand_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return brand;
            }
        });
    }

    @Override
    public Brand getOne(Integer id) {
        return JdbcUtil.getOne("select * from brand where id=?", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet rs) {
                Brand brand = new Brand();
                try {
                    brand.setId(rs.getInt("id"));
                    brand.setBrandName(rs.getString("brand_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return brand;
            }
        },id);
    }

    @Override
    public Brand getOne(String brandName) {
        return JdbcUtil.getOne("select * from brand where brand_name=?", new RowMap<Brand>() {
            @Override
            public Brand RowMapping(ResultSet rs) {
                Brand brand = new Brand();
                try {
                    brand.setId(rs.getInt("id"));
                    brand.setBrandName(rs.getString("brand_name"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return brand;
            }
        },brandName);
    }

    @Override
    public int update(Brand brand) {
        return JdbcUtil.executeUpdate("update brand set brand_name=? where id=?",brand.getBrandName(),brand.getId());
    }

    @Override
    public int delete(Integer id) {
        return JdbcUtil.executeUpdate("delete from brand where id=?",id);
    }

    @Override
    public int add(Brand brand) {
        return JdbcUtil.executeUpdate("insert into brand(brand_name) values (?)",brand.getBrandName());
    }
}
