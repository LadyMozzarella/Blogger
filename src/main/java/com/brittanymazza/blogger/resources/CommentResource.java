package com.brittanymazza.blogger.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	public CommentResource() {}
}