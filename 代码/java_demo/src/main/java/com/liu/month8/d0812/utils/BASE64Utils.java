package com.liu.month8.d0812.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * ClassName: BASE64Utils <br/>
 * Description: <br/>
 * date: 2020/8/12 16:20<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class BASE64Utils {
    private static final BASE64Encoder BASE_64_ENCODER = new BASE64Encoder();
    private static final BASE64Decoder BASE_64_DECODER = new BASE64Decoder();

    /**
     * @Description: 加密
     * @auther: liucong
     * @date: 2020/8/12 16:22
     * @return:
     */
    public static String  encode(String key) {
        return BASE_64_ENCODER.encodeBuffer(key.getBytes());
    }

    /**
     * @Description: 解密
     * @auther: liucong
     * @date: 2020/8/12 16:24
     * @return:
     */
    public static String decode(String key) {
        try {
            byte[] bytes = BASE_64_DECODER.decodeBuffer(key);
            return new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
