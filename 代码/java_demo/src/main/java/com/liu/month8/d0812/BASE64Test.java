package com.liu.month8.d0812;

import com.liu.month8.d0812.utils.BASE64Utils;
import com.liu.month8.d0812.utils.MD5_BASE64Utils;
import org.junit.Test;

/**
 * ClassName: BASE64Test <br/>
 * Description: <br/>
 * date: 2020/8/12 16:15<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class BASE64Test {
    /**
     * @Description: 测试 BASE64 加密
     * @auther: liucong
     * @date: 2020/8/12 16:27
     * @return:
     */
    @Test
    public void test01() {
        System.out.println(BASE64Utils.encode("123"));
    }

    /**
     * @Description: 测试 BASE64 解密
     * @auther: liucong
     * @date: 2020/8/12 16:31
     * @return:
     */
    @Test
    public void test02() {
        System.out.println(BASE64Utils.decode("MTIz"));
    }

    @Test
    public void test03() {
        String s1 = MD5_BASE64Utils.encode2BASE64("123");
        String s2 = MD5_BASE64Utils.encode2BASE64("123");
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test04() {
        String s1 = MD5_BASE64Utils.decode2BASE64("3434643543");
        String s2 = MD5_BASE64Utils.decode2BASE64("3434643543");
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test05() {
        String s = MD5_BASE64Utils.encode2BASE64("42767516990368493138776584305024125808");
        System.out.println(s);
    }

    @Test
    public void test06() {
        String s = MD5_BASE64Utils.decode2BASE64("NDI3Njc1MTY5OTAzNjg0OTMxMzg3NzY1ODQzMDUwMjQxMjU4MDg=");
        System.out.println(s);
    }
}
