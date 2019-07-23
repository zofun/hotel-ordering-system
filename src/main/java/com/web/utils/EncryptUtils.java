package com.web.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author TCW
 * 处理密码加密
 */
public class EncryptUtils {

    /**
     * 用户注册时加密用户的密码
     * 输入密码明文 返回密文与盐值
     *
     * @param password 密码
     * @return 第一个是密文  第二个是盐值
     */
    public static String[] encryptPassword(String password) {
        //生成盐值
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        //生成的密文
        String ciphertext = new Md5Hash(password, salt, 3).toString();

        String[] strings = new String[]{salt, ciphertext};

        return strings;
    }

    /**
     * 获得本次输入的密码的密文，在登录时根据用户名查询盐值，然后根据登录时输入的密码和盐值计算密文
     * 然后进行在数据库中的密码进行比较如果相等则登录成功
     *
     * @param password 密码
     * @param salt 盐值
     * @return
     */
    public static String getInputPasswordCiph(String password, String salt) {
        if (salt == null) {
            password = "";
        }
        //生成的密文
        String ciphertext = new Md5Hash(password, salt, 3).toString();

        return ciphertext;
    }

}
