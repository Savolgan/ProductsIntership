package com.olga.olga.controller;


import com.olga.olga.dto.AddToBucketDto;
import com.olga.olga.dto.BucketDto;
import com.olga.olga.entity.Bucket;
import com.olga.olga.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buckets")
@RequiredArgsConstructor
public class BucketsController {
    private final BucketService bucketService;

    @GetMapping
    public List<Bucket> getAllBuckets() {
        return bucketService.getAllBuckets();
    }

    @PostMapping("/save")
    public Bucket saveBucket(@RequestBody BucketDto bucketDto) {
        return bucketService.saveBucket(bucketDto);
    }

    @PostMapping("/addToBucket")
    public Bucket AddProductsToBucket(@RequestBody AddToBucketDto addToBucketDto) throws ClassNotFoundException {
        return bucketService.addProductInBucket(addToBucketDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBucketById(@PathVariable(value = "id") int id) {
        bucketService.deleteBucketById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllBuckets() {
        bucketService.deleteAllBuckets();
    }

    @PutMapping("/update/{id}")
    public Bucket updateById(@PathVariable(value = "id") Integer id, @RequestBody BucketDto bucketDto) {
        return bucketService.updateBucketById(id, bucketDto);
    }
}
