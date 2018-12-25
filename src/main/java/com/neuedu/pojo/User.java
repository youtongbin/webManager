package com.neuedu.pojo;

import lombok.Data;

@Data
public class User extends Base {
    private String username;
    private String password;
    private String tele;

    public User() {
    }

    public User(String username, String password, String tele) {
        this.username = username;
        this.password = password;
        this.tele = tele;
    }

    public User(Integer id, String username, String password, String tele) {
        super(id);
        this.username = username;
        this.password = password;
        this.tele = tele;
    }

}
