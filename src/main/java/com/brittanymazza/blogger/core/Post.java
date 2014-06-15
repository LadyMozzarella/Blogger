package com.brittanymazza.blogger.core;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class Post {
    private long id;
    private long user_id;
    private Timestamp timestamp;

    @Length(max = 100)
    private String title;
    
    private String content;
    

    public Post(long id, String title, String content, long user_id, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.timestamp = timestamp;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }
    
    @JsonProperty
    public String getContent() {
    	return content;
    }
    
    @JsonProperty
    public long getUserId() {
    	return user_id;
    }
    
    @JsonProperty
    public Timestamp getTimestamp() {
    	return timestamp;
    }
    
}
