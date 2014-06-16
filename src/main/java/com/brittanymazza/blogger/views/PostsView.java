package com.brittanymazza.blogger.views;

import io.dropwizard.views.View;

import java.util.List;
import com.brittanymazza.blogger.core.Post;

public class PostsView extends View {
	private final List<Post> posts;
	
	public PostsView(List<Post> posts) {
        super("posts.mustache");
		this.posts = posts;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
}