package com.brittanymazza.blogger.resources;

import com.brittanymazza.blogger.core.User;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/blogger")
@Produces(MediaType.APPLICATION_JSON)
public class BloggerResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public BloggerResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public User sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new User(counter.incrementAndGet(), value);
    }
}
