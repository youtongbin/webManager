package com.neuedu.pojo;

import lombok.Data;

@Data
public class Brand extends Base {
    private String brandName;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(Integer id, String brandName) {
        super(id);
        this.brandName = brandName;
    }
}
