package com.neuedu.pojo;

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    @Override
    public String toString() {
        return "RoleFunction{" +
                "roleId=" + roleId +
                ", functionId=" + functionId +
                '}';
    }
}
