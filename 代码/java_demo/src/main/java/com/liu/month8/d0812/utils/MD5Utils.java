package com.liu.month8.d0812.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: MD5Utils <br/>
 * Description: <br/>
 * date: 2020/8/12 17:00<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class MD5Utils {
    /**
     * @Description: 加密
     * @auther: liucong
     * @date: 2020/8/12 17:01
     * @return:
     */
    public static String encode(String key) {
        try {
            return String.valueOf(MessageDigest.getInstance("md5").digest(key.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
