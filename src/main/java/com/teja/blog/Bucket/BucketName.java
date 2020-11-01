package com.teja.blog.Bucket;

public enum BucketName {
    PROFILE_IMAGE("saiteja-konda");
    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
