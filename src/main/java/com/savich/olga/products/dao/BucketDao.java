package com.savich.olga.products.dao;

import com.savich.olga.products.entity.Bucket;
import org.springframework.data.repository.CrudRepository;

public interface BucketDao extends CrudRepository<Bucket,Integer> {
}
