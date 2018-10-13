package com.example.harshitagrawal.quickmeds_delivery;

public class DeliveryProfile {
    String name,email,pass,phone;
    public DeliveryProfile()
    {

    }

    public DeliveryProfile(String name, String email, String pass, String phone) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }
}
