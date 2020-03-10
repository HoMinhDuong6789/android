package com.example.learnbasicjson.model;

/**
 * Create by mitt on 3/10/2020.
 */
public class Contact {
    private String name;
    private String city;
    private String company;

    public Contact() {
    }

    public Contact(String name, String city, String company) {
        this.name = name;
        this.city = city;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
