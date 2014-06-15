package com.brittanymazza.blogger.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
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
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(String jsonString) throws IOException {
		HashMap<String,Object> userHash;
		userHash = new ObjectMapper().readValue(jsonString, new TypeReference<HashMap<String,Object>>() {});
		userDAO.insert(counter.incrementAndGet(), userHash.get("username").toString(), userHash.get("password").toString());
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
