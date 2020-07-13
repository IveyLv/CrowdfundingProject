package com.ivey.crowd.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/13 11:52
 * @Version 1.0
 */
@FeignClient("crowd-redis-provider")
public interface RedisRemoteService {
}
