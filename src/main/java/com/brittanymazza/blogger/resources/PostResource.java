package com.brittanymazza.blogger.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.brittanymazza.blogger.db.CommentDAO;
import com.brittanymazza.blogger.db.PostDAO;
import com.brittanymazza.blogger.db.UserDAO;
import com.brittanymazza.blogger.views.CreatePostView;
import com.brittanymazza.blogger.views.PostView;
import com.brittanymazza.blogger.views.PostsView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/posts")
@Produces(MediaType.TEXT_HTML)
public class PostResource {
	
	private final UserDAO userDAO;
	private final PostDAO postDAO;
	private final CommentDAO commentDAO;
	private final AtomicInteger counter;
	
	public PostResource(PostDAO postDAO, UserDAO userDAO, CommentDAO commentDAO) {
		this.postDAO = postDAO;
		this.userDAO = userDAO;
		this.commentDAO = commentDAO;
		this.counter = new AtomicInteger();
	}
	
	@POST
	@UnitOfWork
	public PostsView createPost(@FormParam("username") String username, @FormParam("password") String password, @FormParam("title") String title, @FormParam("content") String content ) throws IOException {
		if( userDAO.findUserByUsername(username).getPassword().equals(password) ) {
			postDAO.insert(counter.incrementAndGet(), title, content, userDAO.findUserByUsername(username).getId(), new Timestamp(new Date().getTime()));
		}
		return new PostsView(postDAO.findAll());
	}
	
	@GET @Path("/new")
	@UnitOfWork
	public CreatePostView createPost() {
		return new CreatePostView();
	}
	
	@GET @Path("/{id}")
	@UnitOfWork
	public PostView viewPost(@PathParam("id") Integer id) {
		return new PostView(postDAO.findPostById(id), userDAO.findUserById( postDAO.findUserIdByPost(id) ), commentDAO.findCommentsByPostId(id) );
	}
	
	@GET @Path("/{id}/comments/new")
	@UnitOfWork
	public int createComment() {
		return 3;
	}
	
	@POST @Path("/{id}/comments")
	@UnitOfWork
	public PostView createComment(@PathParam("id") Integer id, @FormParam("username") String username, @FormParam("password") String password, @FormParam("content") String content ) throws IOException {
		if( userDAO.findUserByUsername(username).getPassword().equals(password) ) {
			commentDAO.insert(counter.incrementAndGet(), content, userDAO.findUserByUsername(username).getId(), id, new Timestamp(new Date().getTime()));
		}
		return new PostView(postDAO.findPostById(id), userDAO.findUserById( postDAO.findUserIdByPost(id) ), commentDAO.findCommentsByPostId(id) );
	}
}