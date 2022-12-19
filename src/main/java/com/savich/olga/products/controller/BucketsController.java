package com.savich.olga.products.controller;

import com.savich.olga.products.dto.BucketDto;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.service.BucketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/buckets")
public class BucketsController {
    private final BucketService bucketService;

    public BucketsController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping
    public List<Bucket> getAllBuckets() {
        return bucketService.getAllBuckets();
    }

    @GetMapping("/get/{id}")
    public Bucket getBucket(@PathVariable(value = "id") int id) {
        return bucketService.getBucketById(id);
    }

    @PostMapping("/save")
    public Bucket saveBucket(@RequestBody BucketDto bucketDto) {
        return bucketService.saveBucket(bucketDto);
    }

    @PutMapping("/update/{id}")
    public void updateBucket(@PathVariable(value = "id") int id, @RequestBody BucketDto bucketDto) {
        bucketService.updateBucket(id, bucketDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBucket(@PathVariable(value = "id") int id) {
        bucketService.deleteBucketById(id);
    }
}
