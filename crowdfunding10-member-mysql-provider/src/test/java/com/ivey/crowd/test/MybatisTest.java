package com.ivey.crowd.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/11 22:40
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    private Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Resource
    private DataSource dataSource;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("数据源连接" + connection.toString());
    }
}
