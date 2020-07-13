package com.ivey.crowd.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/12 20:40
 * @Version 1.0
 */
@FeignClient("crowd-mysql-provider")
public interface MySQLRemoteService {
}
