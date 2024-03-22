package com.f2x.models;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String job;


    public User (String email,String firstName, String lastName, String job ) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.email = email.trim();
        this.job = job.trim();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJob(){
        return job;
    }
}
