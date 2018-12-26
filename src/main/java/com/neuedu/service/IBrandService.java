package com.neuedu.service;

import com.neuedu.pojo.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> getLists();
    Brand getOne(Integer id);
    Brand getOne(String brandName);
    int update(Brand brand);
    int delete(Integer id);
    int add(Brand brand);
}
