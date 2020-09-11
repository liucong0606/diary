package com.liu.month8.d0814.proxy_jdk1;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: JDKProxyTest
 * @Description:
 * @date: 2020/8/14 15:09
 */
public class JDKProxyTest {
    @Test
    public void test01() {
        ISinger singer = new Singer("Camila");
        ISinger proxy = (ISinger) ProxyFactory.getProxy(singer);
        proxy.sing();
    }
}
