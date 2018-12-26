package com.neuedu.service;

import com.neuedu.dao.BrandDao;
import com.neuedu.dao.IBrandDao;
import com.neuedu.pojo.Brand;

import java.util.List;

public class BrandService implements IBrandService {
    IBrandDao brandDao = new BrandDao();
    @Override
    public List<Brand> getLists() {
        return brandDao.getLists();
    }

    @Override
    public Brand getOne(Integer id) {
        return brandDao.getOne(id);
    }

    @Override
    public Brand getOne(String brandName) {
        return brandDao.getOne(brandName);
    }

    @Override
    public int update(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandDao.delete(id);
    }

    @Override
    public int add(Brand brand) {
        return brandDao.add(brand);
    }
}
