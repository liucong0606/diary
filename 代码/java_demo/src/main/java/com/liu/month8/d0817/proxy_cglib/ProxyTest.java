package com.liu.month8.d0817.proxy_cglib;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: ProxyTest
 * @Description:
 * @date: 2020/8/17 9:56
 */
public class ProxyTest {
    @Test
    public void test01() {
        Mi proxy = (Mi) ProxyFactory.getProxy(Mi.class);
        proxy.begin();
        proxy.end();
    }
}
