package com.example.Advisor.model;

public class Credential {
    private static String username;
    private String password;


    public Credential() {
    }


    public Credential(String username, String password) {
        Credential.username = username;
        this.password = password;
    }


    public static String getUsername() {
        //return this.username;
        return username;
    }

    public void setUsername(String username) {
        Credential.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
