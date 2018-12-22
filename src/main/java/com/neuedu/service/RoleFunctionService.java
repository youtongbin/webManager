package com.neuedu.service;

import com.neuedu.dao.IRoleFunctionDao;
import com.neuedu.dao.RoleFunctionDaoImpl;
import com.neuedu.pojo.RoleFunction;

import java.util.List;

public class RoleFunctionService implements IRoleFunctionService {
    IRoleFunctionDao roleFunctionDao = new RoleFunctionDaoImpl();
    @Override
    public List<RoleFunction> getLists(Integer roleId) {
        return roleFunctionDao.getLists(roleId);
    }
}
