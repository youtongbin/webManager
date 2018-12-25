package com.neuedu.dao;

import com.neuedu.pojo.Product;
import myTools.util.JdbcUtil;
import myTools.util.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public List<Product> getLists() {
        return JdbcUtil.executeQuery("select * from product", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product product = new Product();
                try {
                    product.setId(rs.getInt("id"));
                    product.setBrandId(rs.getInt("brand_id"));
                    product.setProductName("product_name");
                    product.setPrice(rs.getDouble("price"));
                    product.setUrl("url");
                    product.setStock(rs.getInt("stock"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return product;
            }
        });
    }

    @Override
    public List<Product> getLists(int pageNo, int pageSize) {
        return JdbcUtil.executeQuery("select * from product limit ?,?", new RowMap<Product>() {
            @Override
            public Product RowMapping(ResultSet rs) {
                Product product = new Product();
                try {
                    product.setId(rs.getInt("id"));
                    product.setBrandId(rs.getInt("brand_id"));
                    product.setProductName("product_name");
                    product.setPrice(rs.getDouble("price"));
                    product.setUrl("url");
                    product.setStock(rs.getInt("stock"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return product;
            }
        }, (pageNo - 1) * pageSize, pageSize);
    }

    @Override
    public int getCount() {
        return JdbcUtil.executeCount("select count(*) from product",null);
    }
}
