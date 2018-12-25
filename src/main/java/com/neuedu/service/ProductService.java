package com.neuedu.service;

import com.neuedu.dao.IProductDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.pojo.Product;
import com.neuedu.pojo.ProductsData;

import java.util.List;

public class ProductService implements IProductService {
    IProductDao productDao = new ProductDao();

    @Override
    public List<Product> getLists() {
        return productDao.getLists();
    }

    @Override
    public ProductsData getLists(int pageNo, int pageSize) {
        ProductsData productsData = new ProductsData(pageNo,pageSize,productDao.getCount());
        productsData.setLists(productDao.getLists(pageNo,pageSize));


        return productsData;
    }

}
