package com.brittanymazza.blogger;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.brittanymazza.blogger.resources.BloggerResource;
//import com.brittanymazza.blogger.health.TemplateHealthCheck;

public class BloggerApplication extends Application<BloggerConfiguration> {
    public static void main(String[] args) throws Exception {
        new BloggerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<BloggerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(BloggerConfiguration configuration,
                    Environment environment) {
        final BloggerResource resource = new BloggerResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}

