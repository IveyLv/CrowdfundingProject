package com.ivey.crowd.service;

import com.ivey.crowd.entity.Admin;

import java.util.List;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/6/28 16:14
 * @Version 1.0
 */
public interface AdminService {

    int saveAdmin(Admin admin);

    List<Admin> getAll();
}