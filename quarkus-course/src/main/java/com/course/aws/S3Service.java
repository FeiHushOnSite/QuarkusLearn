package com.course.aws;

import software.amazon.awssdk.services.s3.model.S3Object;

import java.util.List;

public interface S3Service {

    String putObject(byte[] bytes, String filename, String prefix);

    List<S3Object> listObjects(String prefix);

    void deletebjects(String filename, String prefix);

    void deletebjects(List<String> keys);


}
