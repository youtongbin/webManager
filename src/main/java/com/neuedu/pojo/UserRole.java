package com.neuedu.pojo;

import lombok.Data;

@Data
public class UserRole extends Base {
    private Integer userId;
    private Integer roleId;

    public UserRole() {
    }

    public UserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole(Integer id, Integer userId, Integer roleId) {
        super(id);
        this.userId = userId;
        this.roleId = roleId;
    }

}
