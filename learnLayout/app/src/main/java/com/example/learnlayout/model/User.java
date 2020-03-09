package com.example.learnlayout.model;

/**
 * Create by mitt on 3/5/2020.
 */
public class User {
        private String ten;
        private boolean ischeked;

    public User(String ten, boolean ischeked) {
        this.ten = ten;
        this.ischeked = ischeked;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isIscheked() {
        return ischeked;
    }

    public void setIscheked(boolean ischeked) {
        this.ischeked = ischeked;
    }
}
