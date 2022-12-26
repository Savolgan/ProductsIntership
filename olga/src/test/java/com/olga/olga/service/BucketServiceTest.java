package com.olga.olga.service;

import com.olga.olga.dao.BucketDao;
import com.olga.olga.dto.BucketDto;
import com.olga.olga.entity.Bucket;
import com.olga.olga.entity.Product;
import com.olga.olga.entity.User;
import com.olga.olga.mapping.BucketMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class BucketServiceTest {
    private BucketDao bucketDao;
    private BucketMapper bucketMapper;
    private ProductService productService;
    private UserService userService;
    private BucketService bucketService;
    private List<Bucket> bucketList;

    private BucketDto bucketDto;

    @BeforeEach
    public void init() {
        bucketList = new ArrayList<>();
        bucketDao = Mockito.mock(BucketDao.class);
        bucketService = new BucketService(bucketDao, bucketMapper, productService, userService);
        bucketMapper = new BucketMapper();
        bucketDto = new BucketDto();
    }

    @Test
    public void shouldSaveBucketWhenCallSaveBucket() {
        Bucket bucket = new Bucket();
        bucket.setId(7);
        bucket.setName("TestBucket");
        User user = new User();
        user.setId(7);
        user.setName("TestUser");
        bucket.setUser(user);
        bucketDao.save(bucket);
        verify(bucketDao).save(bucket);
    }

    @Test
    public void shouldReturnAllBucketsWhenCallGetAllBuckets() {
        when(bucketDao.findAll()).thenReturn(bucketList);
        List<Bucket> resultList = bucketService.getAllBuckets();
        assertThat(resultList).isEqualTo(bucketList);
    }

    @Test
    public void shouldReturnBucketWhenCallGetById() {
        Integer id = 2;
        Bucket bucket = new Bucket();
        when(bucketDao.findById(id)).thenReturn(Optional.of(bucket));
        Bucket resultBucket = bucketService.getBucketById(id);
        assertThat(resultBucket).isEqualTo(bucket);
    }

    @Test
    public void shouldSaveBucketWhenGetAddProductInBucket() {
        Bucket bucket = new Bucket();

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(7);
        product1.setName("ProductTest1");
        product1.setPrice(BigDecimal.valueOf(5.75));
        productList.add(product1);

        Product product2 = new Product();
        product2.setId(5);
        product2.setName("ProductTest2");
        product2.setPrice(BigDecimal.valueOf(0.75));
        productList.add(product2);

        bucket.setProductList(productList);
        bucketDao.save(bucket);
        verify(bucketDao).save(bucket);
    }

    @Test
    public void shouldDeleteAllBucketsWhenCallDeleteAll() {
        bucketService.deleteAllBuckets();
        assertTrue(bucketList.size() == 0);
    }

}