package com.ivey.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @Description
 * @Author IveyLv
 * @Date 2020/7/6 11:03
 * @Version 1.0
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {

        return privateEncode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String formPassword = privateEncode(rawPassword);

        return Objects.equals(formPassword, encodedPassword);
    }

    /**
     * 密码加密
     * @param rawPassword 明文密码
     * @return 加密后的密文
     */
    private String privateEncode(CharSequence rawPassword) {
        try {
            // 1. 创建 MessageDigest 对象
            String algorithm = "MD5";
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 2. 获取rawPassword的字节数组
            byte[] input = ((String) rawPassword).getBytes();

            // 3. 加密
            byte[] output = messageDigest.digest(input);

            // 4. 转换为16进制数对应的字符

            return new BigInteger(1, output).toString(16).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
