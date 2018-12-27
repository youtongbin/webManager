package com.neuedu.pojo;

import lombok.Data;

@Data
public class UsersRole {
    private User user;
    private String roleName;

    public UsersRole(){

    }

    public UsersRole(User user,String roleName){
        this.user = user;
        this.roleName = roleName;
    }
}
