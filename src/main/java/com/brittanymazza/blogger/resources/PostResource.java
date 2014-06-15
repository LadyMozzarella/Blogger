package com.brittanymazza.blogger.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brittanymazza.blogger.core.Post;
import com.brittanymazza.blogger.db.PostDAO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {
	
	private final PostDAO postDAO;
	private final AtomicInteger counter;
	
	public PostResource(PostDAO postDAO) {
		this.postDAO = postDAO;
		this.counter = new AtomicInteger();
	}
	
	@POST
	@UnitOfWork
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPost(String jsonString) throws IOException {
		HashMap<String,Object> postHash;
		postHash = new ObjectMapper().readValue(jsonString, new TypeReference<HashMap<String,Object>>() {});
		System.out.println(postHash.get("user_id"));
		postDAO.insert(counter.incrementAndGet(), postHash.get("title").toString(), postHash.get("content").toString(), Integer.parseInt(postHash.get("user_id").toString()), new Timestamp(new Date().getTime()));
	}
	
	@GET @Path("/new")
	@UnitOfWork
	public int createPost() {
		return 3;
	}
	
	@GET @Path("/{id}")
	@UnitOfWork
	public Post viewPost(@PathParam("id") Integer id) {
		return postDAO.findPostById(id);
	}
}