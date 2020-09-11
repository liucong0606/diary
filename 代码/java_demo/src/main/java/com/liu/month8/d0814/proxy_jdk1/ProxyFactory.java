package com.liu.month8.d0814.proxy_jdk1;

import java.lang.reflect.Proxy;

/**
 * @author liucong
 * @ClassName: ProxyFactory
 * @Description:
 * @date: 2020/8/14 15:05
 */
public class ProxyFactory {
    public static Object getProxy(Object obj) {
        MyInvocationHandler ih = new MyInvocationHandler();
        ih.setProxy(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), ih);
        return o;
    }
}
