package com.example.btlistdatabindingcontact.model;

/**
 * Create by mitt on 3/9/2020.
 */
public class Contact {
    private String phone;
    private String name;

    public Contact( String name, String phone) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
