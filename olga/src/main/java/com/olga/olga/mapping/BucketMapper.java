package com.olga.olga.mapping;

import com.olga.olga.dto.BucketDto;
import com.olga.olga.entity.Bucket;
import org.springframework.stereotype.Component;

@Component
public class BucketMapper {
    public Bucket mapToBucket(BucketDto bucketDto) {
        Bucket bucket = new Bucket();
        bucket.setName(bucketDto.getName());
        bucket.setProductList(bucketDto.getProductList());
        return bucket;
    }

}
