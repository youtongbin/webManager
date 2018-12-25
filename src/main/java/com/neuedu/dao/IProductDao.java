package com.neuedu.dao;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductDao {
    List<Product> getLists();
    List<Product> getLists(int pageNo,int pageSize);
    int getCount();
}
