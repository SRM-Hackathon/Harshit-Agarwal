package com.example.harshitagrawal.quickmeds_doc;

public class UserProfiles {

    String id,name,email,password,dob,phone,address;
    public UserProfiles()
    {

    }

    public UserProfiles(String id, String name, String email, String password, String dob, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

}
