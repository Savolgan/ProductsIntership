package com.savich.olga.products.service;

import com.savich.olga.products.dao.BucketDao;
import com.savich.olga.products.dto.BucketDto;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.exception.BucketNotFoundException;
import com.savich.olga.products.mapping.BucketMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BucketService {
    private final BucketDao bucketDao;
    private final BucketMapper bucketMapper;

    public BucketService(BucketDao bucketDao, BucketMapper bucketMapper) {
        this.bucketDao = bucketDao;
        this.bucketMapper = bucketMapper;
    }

    public Bucket saveBucket(BucketDto bucketDto) {
        return bucketDao.save(bucketMapper.mapToBucket(bucketDto));
    }

    public void updateBucket(int id, BucketDto bucketDto) {
        Bucket bucket = bucketMapper.mapToBucket(bucketDto);
        bucket.setId(id);
        bucketDao.save(bucket);
    }

    public void deleteBucketById(int id) {
        bucketDao.deleteById(id);
    }

    public Bucket getBucketById(int id) {
        return bucketDao.findById(id).orElseThrow(() ->
                new BucketNotFoundException("Bucket not found, id is incorrect"));
    }

    public List<Bucket> getAllBuckets() {
        List<Bucket> bucketList = new ArrayList<>();
        bucketDao.findAll().forEach(bucket -> bucketList.add(bucket));
        return bucketList;
    }
}



