package com.neuedu.pojo;

import lombok.Data;

@Data
public class Product extends Base {
    private Integer brandId;
    private String productName;
    private double price;
    private String url;
    private int stock;

    public Product() {
    }

    public Product(Integer brandId, String productName, double price, String url, int stock) {
        this.brandId = brandId;
        this.productName = productName;
        this.price = price;
        this.url = url;
        this.stock = stock;
    }

    public Product(Integer id, Integer brandId, String productName, double price, String url, int stock) {
        super(id);
        this.brandId = brandId;
        this.productName = productName;
        this.price = price;
        this.url = url;
        this.stock = stock;
    }
}
