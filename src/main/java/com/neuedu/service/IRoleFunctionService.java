package com.neuedu.service;

import com.neuedu.pojo.RoleFunction;

import java.util.List;

public interface IRoleFunctionService {
    List<RoleFunction> getLists(Integer roleId);
}
