package com.course.aws;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.core.internal.util.Mimetype;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Delete;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Object;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class S3ServiceImpl implements S3Service {

    static {
        //可以构建时候用参数启动
        System.setProperty("aws.accessKeyId","********************");
        System.setProperty("aws.secretAccessKey","*****************************");
    }

    @ConfigProperty(name = "custom.s3.bucket.name")
    String bucketName;

    @Inject
    S3Client s3;

    @Inject
    S3AsyncClient s3Async;

    @Override
    public String putObject(byte[] bytes, String filename, String prefix) {
        PutObjectResponse putObjectResponse = s3.putObject(buildPutRequest(prefix + filename),
                RequestBody.fromBytes(bytes));
        return putObjectResponse.requestChargedAsString();
    }

    @Override
    public List<S3Object> listObjects(String prefix) {
        ListObjectsRequest listRequest = ListObjectsRequest.builder().bucket(bucketName).prefix(prefix).build();
        return s3.listObjects(listRequest).contents();
    }

    @Override
    public void deletebjects(String filename, String prefix) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName).key(prefix + filename).build();
        s3.deleteObject(deleteObjectRequest);
    }

    @Override
    public void deletebjects(List<String> keys) {
        List<ObjectIdentifier> identifiers = keys.stream().map(key -> ObjectIdentifier.builder().key(key).build()).collect(Collectors.toList());
        DeleteObjectsRequest deleteObjectsRequest = DeleteObjectsRequest.builder()
                .bucket(bucketName)
                .delete(Delete.builder().objects(identifiers).quiet(false).build())
                .build();
        s3Async.deleteObjects(deleteObjectsRequest);
    }


    private PutObjectRequest buildPutRequest(String filename) {
        return PutObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .contentType(Mimetype.MIMETYPE_OCTET_STREAM)
                .build();
    }
}
