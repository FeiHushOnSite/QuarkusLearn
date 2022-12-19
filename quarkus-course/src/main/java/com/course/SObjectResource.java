package com.course;

import com.course.aws.S3Service;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @program: quarkus-course
 * @className: S3Resource
 * @description:
 * @author:
 * @create: 2022-12-15 13:20
 * @Version 1.0
 **/
@Path("/S3")
public class SObjectResource {

    @Inject
    S3Service service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<S3Object> upload() {
        return service.listObjects("images");
    }
}
