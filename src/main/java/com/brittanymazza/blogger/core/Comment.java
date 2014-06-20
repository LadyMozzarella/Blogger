package com.brittanymazza.blogger.core;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

public class Comment {
    private long id;
    private long user_id;
    private long post_id;
    private Timestamp timestamp;

    @Length(max = 100)
    private String title;
    
    private String content;
    
    public Comment(long id, String content, long user_id, long post_id, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.user_id = user_id;
        this.post_id = post_id;
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
    
    @JsonProperty
    public long getPostId() {
    	return post_id;
    }
}