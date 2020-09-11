package com.liu.month8.d0817.proxy_static;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: ProxyTest
 * @Description:
 * @date: 2020/8/17 9:29
 */
public class ProxyTest {
    @Test
    public void test01() {
        ProxyManager pm = new ProxyManager(new Mi());
        pm.begin();
        pm.end();
    }
}
