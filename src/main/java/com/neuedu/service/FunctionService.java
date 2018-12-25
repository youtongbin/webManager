package com.neuedu.service;

import com.neuedu.dao.FunctionDaoImpl;
import com.neuedu.dao.IFunctionDao;
import com.neuedu.pojo.Function;

public class FunctionService implements IFunctionService {
    IFunctionDao functionDao = new FunctionDaoImpl();
    @Override
    public Function getOne(Integer functionId) {
        return functionDao.getOne(functionId);
    }
}
