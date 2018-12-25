package com.neuedu.pojo;

import lombok.Data;

@Data
public class Function extends Base {
    private String url;

    public Function() {
    }

    public Function(String url) {
        this.url = url;
    }

    public Function(Integer id, String url) {
        super(id);
        this.url = url;
    }

}
