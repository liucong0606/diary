package com.liu.month8.d0812.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: MD5$BASE64Utils <br/>
 * Description: <br/>
 * date: 2020/8/12 17:07<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class MD5_BASE64Utils {
    private static final BASE64Encoder BASE_64_ENCODER = new BASE64Encoder();
    private static final BASE64Decoder BASE_64_DECODER = new BASE64Decoder();
    private static MessageDigest md5;

    private MD5_BASE64Utils() {

    }

    /**
     * @Description: 初始化 MessageDigest
     * @auther: liucong
     * @date: 2020/8/13 10:12
     * @return:
     */
    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 先MD5加密，再BASE64加密
     * @auther: liucong
     * @date: 2020/8/12 17:08
     * @return:
     */
    public static String encode(String key) {
        String md5Key = encode2MD5(key);
        return encode2BASE64(md5Key);
    }

    /**
     * @Description: MD5加密
     * @auther: liucong
     * @date: 2020/8/12 17:35
     * @return:
     */
    public static String encode2MD5(String key) {
        try {
            md5.update(key.getBytes());
            BigInteger bi = new BigInteger(md5.digest());
            return String.valueOf(bi);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: BASE64 加密
     * @auther: liucong
     * @date: 2020/8/12 17:36
     * @return:
     */
    public static String encode2BASE64(String key) {
        try {
            return BASE_64_ENCODER.encodeBuffer(key.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: BASE64 解密
     * @auther: liucong
     * @date: 2020/8/12 17:37
     * @return:
     */
    public static String decode2BASE64(String key) {
        try {
            byte[] bys = BASE_64_DECODER.decodeBuffer(key);
            return new String(bys, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 比较输入的密码和加密的密码是否相同
     * @auther: liucong
     * @date: 2020/8/12 17:11
     * @return:
     */
    public static boolean equals(String pwd, String key) {
        // String encode = encode(pwd).replaceAll("\r\n", "");
        // key = key.replaceAll("\r\n", "");
        pwd = encode2MD5(pwd);
        key = decode2BASE64(key);
        return pwd.equals(key);
    }
}
