package com.ivey.crowd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/13 11:42
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();

        operations.set("apple", "red");
    }
}
