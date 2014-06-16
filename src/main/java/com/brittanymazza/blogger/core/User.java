package com.brittanymazza.blogger.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class User {
    private int id;

    @Length(max = 100)
    private String username;
    
    @Length(max = 100)
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }
    
    @JsonIgnore
    public String getPassword() {
    	return password;
    }
}