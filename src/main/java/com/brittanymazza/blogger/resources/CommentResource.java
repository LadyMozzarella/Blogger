package com.brittanymazza.blogger.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brittanymazza.blogger.db.CommentDAO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private final CommentDAO commentDAO;
	private final AtomicInteger counter;
	
	public CommentResource(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
		this.counter = new AtomicInteger();
	}
	
	@POST
	@UnitOfWork
	@Consumes(MediaType.APPLICATION_JSON)
	public void createComment(String jsonString) throws IOException {
		HashMap<String,Object> commentHash;
		commentHash = new ObjectMapper().readValue(jsonString, new TypeReference<HashMap<String,Object>>() {});
		commentDAO.insert(counter.incrementAndGet(), commentHash.get("content").toString(), Integer.parseInt(commentHash.get("user_id").toString()), Integer.parseInt(commentHash.get("post_id").toString()), new Timestamp(new Date().getTime()));
	}
}