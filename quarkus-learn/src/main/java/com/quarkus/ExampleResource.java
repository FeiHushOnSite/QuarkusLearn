package com.quarkus;

import com.quarkus.entity.TzUser;
import com.quarkus.service.UserServiceImpl;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class ExampleResource {

    private static String constant = "";

    @Inject
    UserServiceImpl userService;

    @ConfigProperty(name = "quarkus.params.test")
    String configValue;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        List<TzUser> user = userService.getUser(1);
        user.forEach(e -> constant += e);
        return "Hello RESTEasy" + configValue + constant;
    }
}