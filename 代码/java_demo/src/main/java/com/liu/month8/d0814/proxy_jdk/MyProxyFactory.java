package com.liu.month8.d0814.proxy_jdk;

import java.lang.reflect.Proxy;

/**
 * @author liucong
 * @ClassName: MyProxyFactory
 * @Description:
 * @date: 2020/8/14 14:42
 */
public class MyProxyFactory {
    public static Object getTarget(Object target) {
        MyInvocationHandle ih = new MyInvocationHandle();
        ih.setTarget(target);
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), ih);
        return proxy;
    }
}
