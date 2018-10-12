package com.example.harshitagrawal.quickmeds;

public class UserProfiles {
    String id,name,email,password;
    public UserProfiles()
    {

    }

    public UserProfiles(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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
}
