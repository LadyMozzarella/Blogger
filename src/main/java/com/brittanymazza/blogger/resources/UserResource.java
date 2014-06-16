package com.brittanymazza.blogger.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brittanymazza.blogger.core.Post;
import com.brittanymazza.blogger.core.User;
import com.brittanymazza.blogger.db.PostDAO;
import com.brittanymazza.blogger.db.UserDAO;
import com.brittanymazza.blogger.views.CreatePostView;
import com.brittanymazza.blogger.views.CreateUserView;

@Path("/users")
@Produces(MediaType.TEXT_HTML)
public class UserResource {
	
	private final UserDAO userDAO;
	private final PostDAO postDAO;
	private final AtomicInteger counter;
	
	public UserResource(UserDAO userDAO, PostDAO postDAO) {
		this.userDAO = userDAO;
		this.postDAO = postDAO;
		this.counter = new AtomicInteger();
	}
	
	@POST
	@UnitOfWork
	public CreatePostView createUser(@FormParam("username") String username, @FormParam("password") String password) throws IOException {
		userDAO.insert(counter.incrementAndGet(), username, password);
		return new CreatePostView();
	}	
	
	@GET @Path("/new")
	@UnitOfWork
	public CreateUserView newUser() {
		return new CreateUserView();
	}
	
	@GET
	@UnitOfWork
	public List<User> listUsers() {
		return userDAO.findAll();
	}
	
	@GET @Path("/{id}")
	@UnitOfWork
	public List<Post> viewUser(@PathParam("id") Integer id) {
		return postDAO.findPostsByUserId(id);
	}
}
