package com.course;

import com.course.service.HelloService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    private static final Logger LOG = Logger.getLogger(ExampleResource.class);

    @Inject
    HelloService helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        long executionStart = System.currentTimeMillis();
        String hello = helloService.getHello();
        long executionEnd = System.currentTimeMillis();
        long execution = executionEnd - executionStart;
        LOG.infof(hello + execution);
        return hello + execution;
    }
}