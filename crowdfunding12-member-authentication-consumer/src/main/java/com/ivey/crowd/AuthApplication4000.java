package com.ivey.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/13 12:16
 * @Version 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication4000 {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication4000.class, args);
    }
}
