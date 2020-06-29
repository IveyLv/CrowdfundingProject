package com.ivey.crowd.service.impl;

import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.mapper.AdminMapper;
import com.ivey.crowd.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/6/28 17:47
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public int saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }
}
