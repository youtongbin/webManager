package com.neuedu.pojo;

import lombok.Data;

@Data
public class Base {
    private Integer id;

    public Base() {
    }

    public Base(Integer id) {
        this.id = id;
    }

}
