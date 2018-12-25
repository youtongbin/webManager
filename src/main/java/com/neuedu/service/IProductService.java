package com.neuedu.service;

import com.neuedu.pojo.Product;
import com.neuedu.pojo.ProductsData;

import java.util.List;

public interface IProductService {
    //查询整表
    List<Product> getLists();
    //模糊查询
    List<Product> getLists(String key);
    //分页查询
    ProductsData getLists(int pageNo, int pageSize);
    //分页模糊查询
    ProductsData getLists(int pageNo, int pageSize,String key);
    //获取数据总数
    int getCount();
    //模糊查询条数
    int getCount(String key);
}
