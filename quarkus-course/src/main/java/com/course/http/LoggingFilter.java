//package com.course.http;
//
//import io.vertx.mutiny.core.http.HttpServerRequest;
//import org.jboss.logging.Logger;
//
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.ext.Provider;
//import java.io.IOException;
//
///**
// * @program: QuarkusLearn
// * @className: LoggingFilter
// * @description:
// * @author:
// * @create: 2022-12-13 16:41
// * @Version 1.0
// **/
//@Provider
//public class LoggingFilter implements ContainerRequestFilter {
//
//    private static final Logger LOG = Logger.getLogger(LoggingFilter.class);
//
//    @Context
//    UriInfo info;
//
//    @Context
//    HttpServerRequest request;
//
//    @Override
//    public void filter(ContainerRequestContext context) throws IOException {
//
//        final String method = context.getMethod();
//        final String path = info.getPath();
//        final String address = request.remoteAddress().toString();
//        LOG.infof("Request %s %s from IP %s", method, path, address);
//    }
//}
