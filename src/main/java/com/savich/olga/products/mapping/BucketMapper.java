package com.savich.olga.products.mapping;

import com.savich.olga.products.dto.BucketDto;
import com.savich.olga.products.entity.Bucket;
import org.springframework.stereotype.Component;

@Component
public class BucketMapper {
    public Bucket mapToBucket(BucketDto bucketDto) {
        Bucket bucket = new Bucket();
        bucket.setName(bucketDto.getName());
        return bucket;
    }
}
