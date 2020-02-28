package com.example.recyclerview;

/**
 * Create by mitt on 2/28/2020.
 */
public class DataShop {
        private int hinhAnh;
        private String name;

    public DataShop(int hinhAnh, String name) {
        this.hinhAnh = hinhAnh;
        this.name = name;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
