package com.liu.month8.d0814.proxy_static;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: StaticProxyTest
 * @Description:
 * @date: 2020/8/14 14:32
 */
public class StaticProxyTest {
    /**
     * @Description: 测试静态代理类
     * @auther: liucong
     * @date: 2020/8/14 14:34
     * @return:
     */
    @Test
    public void test01() {
        ProxyManager proxyManager = new ProxyManager(new Singer("周杰伦"));
        proxyManager.sing();
    }
}
