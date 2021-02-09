package com.telynet.viewExamples.Model;

public class Product {
    private String title;
    private String code;
    private Integer image;

    public Product(String title, String code, Integer image) {
        this.title = title;
        this.code = code;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
