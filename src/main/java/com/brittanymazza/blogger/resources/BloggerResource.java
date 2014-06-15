package com.brittanymazza.blogger.resources;

import com.brittanymazza.blogger.core.Post;
import com.brittanymazza.blogger.db.PostDAO;

import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class BloggerResource {
	private final PostDAO postDAO;
	
    public BloggerResource(PostDAO postDAO) {
    	this.postDAO = postDAO;
    }
    
    @GET
	@UnitOfWork
	public List<Post> listPosts() {
		return postDAO.findAll();
	}
}
