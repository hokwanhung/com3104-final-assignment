package com.example.eventup;

public class UserProfile {
    private String username;

    public UserProfile() {
        // Required default constructor for Firebase
    }

    public UserProfile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}