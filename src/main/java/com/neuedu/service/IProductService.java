package com.neuedu.service;

import com.neuedu.pojo.Product;
import com.neuedu.pojo.ProductsData;

import java.util.List;

public interface IProductService {
    List<Product> getLists();
    ProductsData getLists(int pageNo, int pageSize);
}
