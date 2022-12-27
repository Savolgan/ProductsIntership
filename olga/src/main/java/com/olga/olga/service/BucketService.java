package com.olga.olga.service;

import com.olga.olga.LogInFile;
import com.olga.olga.dao.BucketDao;
import com.olga.olga.dto.AddToBucketDto;
import com.olga.olga.dto.BucketDto;
import com.olga.olga.entity.Bucket;
import com.olga.olga.entity.Product;
import com.olga.olga.entity.User;
import com.olga.olga.exception.ClassNotFoundException;
import com.olga.olga.mapping.BucketMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BucketService {
    private final BucketDao bucketDao;
    private final BucketMapper bucketMapper;
    private final ProductService productService;
    private final UserService userService;



    public Bucket saveBucket(BucketDto bucketDto) {
        Bucket bucket = bucketMapper.mapToBucket(bucketDto);
        bucket.setUuid(UUID.randomUUID());
        User user = userService.getUserById(bucketDto.getUserId());
        bucket.setUser(user);
        bucketDao.save(bucket);
        return bucket;
    }

    public List<Bucket> getAllBuckets() {
        List<Bucket> bucketList = new ArrayList<>();
        bucketDao.findAll().forEach(bucket -> bucketList.add(bucket));
        return bucketList;
    }

    public Bucket getBucketById(Integer id) {
        return bucketDao.findById(id).orElseThrow(() ->
                new ClassNotFoundException("Bucket not found, id is incorrect"));
    }
    @Transactional
    public Bucket addProductInBucket(@NotNull AddToBucketDto addToBucketDto) throws java.lang.ClassNotFoundException, IOException {
        Bucket bucket = getBucketById(addToBucketDto.getBucketId());
        List<Product> productList = bucket.getProductList();
        bucket.setProductList(productList);
        Product tempProduct = productService.getProductById(addToBucketDto.getProductId());
        productList.add(tempProduct);
        bucketDao.save(bucket);
        String strForLog="The product "+tempProduct.getName()+" is added to the bucket "+bucket.getName()+"\n";
        LogInFile.logInFile(strForLog);
        return bucket;
    }

    public void deleteBucketById( Integer id){
       bucketDao.deleteById(id);
    }
    public void deleteAllBuckets(){
        bucketDao.deleteAll();
    }

    public Bucket updateBucketById(Integer id, BucketDto bucketDto){
        Bucket bucket = bucketMapper.mapToBucket(bucketDto);
        bucket.setId(id);
        bucketDao.save(bucket);
        return bucket;
    }

}
