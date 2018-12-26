package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    //添加商品
    int addProduct(Product product);
    //修改商品
    int update(Product product);
    //删除商品
    int delete(Integer id);
    //通过品牌id删除（下架）
    int deletes(Integer brandId);
    //查询一条信息
    Product getOne(Integer id);
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
