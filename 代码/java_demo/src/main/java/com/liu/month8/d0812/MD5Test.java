package com.liu.month8.d0812;

import com.liu.month8.d0812.utils.MD5_BASE64Utils;
import com.liu.month8.d0812.utils.MD5Utils;
import org.junit.Test;

/**
 * ClassName: MD5Test <br/>
 * Description: <br/>
 * date: 2020/8/12 16:51<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class MD5Test {
    @Test
    public void test01() {
        // [B@7e0b37bc
        String s = MD5Utils.encode("liucong0606");
        System.out.println(s);
    }

    /**
     * @Description: MD5加密再BASE64加密
     * @auther: liucong
     * @date: 2020/8/12 17:06
     * @return:
     */
    @Test
    public void test02() {
        // String s1 = MD5$BASE64Utils.encode("123");
        // String s2 = MD5$BASE64Utils.encode("123");
        // System.out.println(s1);  // [B@578486a3   W0JANTc4NDg2YTM=
        // System.out.println(s2);  // [B@578486a3   W0JANTc4NDg2YTM=
        // [B@551aa95a
        boolean isEquals = MD5_BASE64Utils.equals("123", "NDI3Njc1MTY5OTAzNjg0OTMxMzg3NzY1ODQzMDUwMjQxMjU4MDg=");
        System.out.println(isEquals);
    }

    @Test
    public void test03() {
        String s1 = MD5_BASE64Utils.encode2MD5("123");
        String s2 = MD5_BASE64Utils.encode2MD5("123");
        System.out.println(s1);
        System.out.println(s2);
    }
}
