package com.example.harshitagrawal.quickmeds_doc;

public class DocProfile {
    String id,name,specialisation,email,pass,phone;
    public DocProfile()
    {

    }

    public DocProfile(String id, String name, String specialisation, String email, String pass, String phone) {
        this.id = id;
        this.name = name;
        this.specialisation = specialisation;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialisation() {
        return specialisation;
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
