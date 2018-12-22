package com.neuedu.pojo;

public class Function extends Base {
    private String url;

    public Function() {
    }

    public Function(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Function{" +
                "url='" + url + '\'' +
                '}';
    }
}
