package com.brittanymazza.blogger.views;

import java.util.List;

import io.dropwizard.views.View;

import com.brittanymazza.blogger.core.Comment;
import com.brittanymazza.blogger.core.Post;
import com.brittanymazza.blogger.core.User;

public class PostView extends View {
    private final Post post;
    private final User user;
    private final List<Comment> comments;

    public PostView(Post post, User user, List<Comment> comments) {
        super("post.mustache");
        this.post = post;
        this.user = user;
        this.comments = comments;
    }

    public Post getPost() {
        return post;
    }
    
    public User getUser() {
    	return user;
    }
    
    public List<Comment> getComments() {
    	return comments;
    }
}
