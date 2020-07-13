package com.ivey.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/13 12:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication80.class, args);
    }
}
