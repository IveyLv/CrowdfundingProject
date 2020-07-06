package com.ivey.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/6 11:30
 * @Version 1.0
 */
public class SecurityTest {

    public static void main(String[] args) {

        // 1. 创建 BCryptPasswordEncoder 对象
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 2. 准备明文字符串
        String rawPassword = "123456";

        // 3. 加密
        String encode = passwordEncoder.encode(rawPassword);
        System.out.println(encode);
        // $2a$10$1L0pKwhAcbQJN6CcobkJMeYzB7PgiHQaAectH3u4t6d6CTXuiyeIW
        // $2a$10$xLKl5rHHSGFN9cFoM2sznu.2bEqfOmr3AOnuEzEOXVtERPIp62TiS
        // $2a$10$j76nV8QNnTcTDnAvWm77nu6jUk9iweMmlcJy4AC8m/4WjpezfpHfu
    }
}
