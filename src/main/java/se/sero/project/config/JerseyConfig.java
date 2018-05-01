package se.sero.project.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import se.sero.project.resource.TodoResource;
import se.sero.project.resource.UserResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(UserResource.class);
        register(TodoResource.class);
    }


}
