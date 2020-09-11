package com.liu.month8.d0817.proxy_jdk;

import java.lang.reflect.Proxy;

/**
 * @author liucong
 * @ClassName: ProxyFactory
 * @Description:
 * @date: 2020/8/17 9:45
 */
public class ProxyFactory {
    public static Object getProxy(Object obj) {
        MyHandler h = new MyHandler();
        h.setC(obj);
        Computer proxy = (Computer) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), h);
        return proxy;
    }
}
