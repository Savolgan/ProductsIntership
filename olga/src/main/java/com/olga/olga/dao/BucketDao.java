package com.olga.olga.dao;

import com.olga.olga.entity.Bucket;
import org.springframework.data.repository.CrudRepository;

public interface BucketDao extends CrudRepository<Bucket, Integer> {
}
