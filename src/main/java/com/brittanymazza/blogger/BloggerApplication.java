package com.brittanymazza.blogger;

import org.skife.jdbi.v2.DBI;

import com.brittanymazza.blogger.db.*;
import com.brittanymazza.blogger.resources.BloggerResource;
import com.brittanymazza.blogger.resources.CommentResource;
import com.brittanymazza.blogger.resources.PostResource;
import com.brittanymazza.blogger.resources.UserResource;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class BloggerApplication extends Application<BloggerConfiguration> {
    public static void main(String[] args) throws Exception {
        new BloggerApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<BloggerConfiguration> bootstrap) {
		bootstrap.addBundle(new ViewBundle());
    }
    
    @Override
    public void run(BloggerConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "db");
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final PostDAO postDAO = jdbi.onDemand(PostDAO.class);
        final CommentDAO commentDAO = jdbi.onDemand(CommentDAO.class);
        
        userDAO.createUsersTable();
        postDAO.createPostsTable();
        commentDAO.createCommentsTable();
        
        environment.jersey().register(new UserResource(userDAO, postDAO));
        environment.jersey().register(new PostResource(postDAO, userDAO, commentDAO));
        environment.jersey().register(new BloggerResource(postDAO));
        environment.jersey().register(new CommentResource());
    }

}

