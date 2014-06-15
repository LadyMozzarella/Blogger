package com.brittanymazza.blogger.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class User {
    private long id;

    @Length(max = 3)
    private String content;

    public User() {
        // Jackson deserialization
    }

    public User(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}