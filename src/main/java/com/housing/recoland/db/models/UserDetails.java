package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class UserDetails {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String name;

    public UserDetails() {
    }

    public UserDetails(String username, String password, String email, String phone, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
