package com.neuedu.pojo;

import lombok.Data;

@Data
public class Role extends Base {
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(Integer id, String roleName) {
        super(id);
        this.roleName = roleName;
    }

}
