package com.neuedu.pojo;

import lombok.Data;

@Data
public class RoleFunction extends Base {
    private Integer roleId;
    private Integer functionId;

    public RoleFunction() {
    }

    public RoleFunction(Integer roleId, Integer functionId) {
        this.roleId = roleId;
        this.functionId = functionId;
    }

    public RoleFunction(Integer id, Integer roleId, Integer functionId) {
        super(id);
        this.roleId = roleId;
        this.functionId = functionId;
    }

}
