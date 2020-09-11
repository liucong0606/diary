package com.liu.month8.d0817.proxy_jdk;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: ProxyTest
 * @Description:
 * @date: 2020/8/17 9:36
 */
public class ProxyTest {
    @Test
    public void test01() {
        Computer c = new Mi();
        Computer proxy = (Computer) ProxyFactory.getProxy(c);
        proxy.begin();
        proxy.end();
    }
}
