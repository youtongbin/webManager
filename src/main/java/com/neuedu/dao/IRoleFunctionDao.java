package com.neuedu.dao;

import com.neuedu.pojo.RoleFunction;

import java.util.List;

public interface IRoleFunctionDao {
    List<RoleFunction> getLists(Integer roleId);
}
