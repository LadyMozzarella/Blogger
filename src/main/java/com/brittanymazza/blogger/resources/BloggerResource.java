package com.brittanymazza.blogger.resources;

import com.brittanymazza.blogger.db.PostDAO;
import com.brittanymazza.blogger.views.PostsView;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class BloggerResource {
	private final PostDAO postDAO;
	
    public BloggerResource(PostDAO postDAO) {
    	this.postDAO = postDAO;
    }
    
    @GET
	@UnitOfWork
	public PostsView listPosts() {
		return new PostsView(postDAO.findAll());
	}
}