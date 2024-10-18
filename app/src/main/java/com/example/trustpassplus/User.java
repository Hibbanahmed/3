package com.example.trustpassplus;

public class User {
    private String id;
    private String name;
    private String email;

    // Default constructor required for calls to DataSnapshot.getValue(User.class)
    public User() {
    }

    // Constructor with id, name, and email
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Constructor with just name and email
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}