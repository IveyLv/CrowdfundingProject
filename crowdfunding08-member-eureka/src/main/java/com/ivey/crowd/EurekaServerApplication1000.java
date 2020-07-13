package com.ivey.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/9 17:08
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication1000 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication1000.class, args);
    }
}
