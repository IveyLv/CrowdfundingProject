package com.ivey.crowd.test;

import com.ivey.crowd.util.CrowdUtil;
import org.junit.Test;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/2 9:01
 * @Version 1.0
 */
public class StringTest {

    @Test
    public void testMD5() {
        String source = "123456";
        String encoded = CrowdUtil.md5(source);
        System.out.println("加密结果：" + encoded);
    }
}
