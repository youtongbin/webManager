package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    //查询整表
    List<Product> getLists();
    //模糊查询
    List<Product> getLists(String key);
    //分页条数查询
    List<Product> getLists(int pageNo,int pageSize);
    //分页模糊查询
    List<Product> getLists(int pageNo,int pageSize,String key);
    //获取数据总数
    int getCount();
    //模糊查询条数
    int getCount(String key);

}
