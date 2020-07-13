package com.ivey.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/11 22:22
 * @Version 1.0
 */
@MapperScan("com.ivey.crowd.mapper")
@SpringBootApplication
public class MysqlApplication2000 {

    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication2000.class, args);
    }
}
