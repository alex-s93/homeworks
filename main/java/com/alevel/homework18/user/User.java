package com.alevel.homework18.user;

import java.io.Serializable;

public class User implements Serializable {
    private String user;
    private String email;
    private String phone;

    User(String user, String email, String phone) {
        this.user = user;
        this.email = email;
        this.phone = phone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User {" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
