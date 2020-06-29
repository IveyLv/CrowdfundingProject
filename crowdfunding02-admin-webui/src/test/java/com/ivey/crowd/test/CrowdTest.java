package com.ivey.crowd.test;

import com.ivey.crowd.entity.Admin;
import com.ivey.crowd.mapper.AdminMapper;
import com.ivey.crowd.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/6/27 22:50
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminService adminService;

    @Test
    public void testConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testInsertAdmin() {
        Admin admin = new Admin(null, "Tom", "123456", "Tom", "Tom@163.com", null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响行数：" + count);
    }

    @Test
    public void testLog() {
        // 1. 获取 Logger 对象，这里传入的是 Class 对象，就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);

        // 2. 根据不同日志级别打印日志
        logger.debug("Debug Level");
        logger.debug("Debug Level");
        logger.debug("Debug Level");

        logger.info("Info Level");
        logger.info("Info Level");
        logger.info("Info Level");

        logger.warn("Warn Level");
        logger.warn("Warn Level");
        logger.warn("Warn Level");

        logger.error("Error Level");
        logger.error("Error Level");
        logger.error("Error Level");
    }

    @Test
    public void testTx() {
        Admin admin = new Admin(null, "Jerry", "123456", "Jerry", "Jerry@163.com", null);
        System.out.println(adminService.saveAdmin(admin));
    }
}
