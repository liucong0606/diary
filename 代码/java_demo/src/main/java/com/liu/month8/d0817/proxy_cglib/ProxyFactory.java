package com.liu.month8.d0817.proxy_cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author liucong
 * @ClassName: ProxyFactory
 * @Description:
 * @date: 2020/8/17 9:52
 */
public class ProxyFactory {
    public static Object getProxy(Class c) {
        Enhancer e = new Enhancer();
        e.setSuperclass(c);
        e.setCallback(new MyInterceptor());
        Object o = e.create();
        return o;
    }
}
