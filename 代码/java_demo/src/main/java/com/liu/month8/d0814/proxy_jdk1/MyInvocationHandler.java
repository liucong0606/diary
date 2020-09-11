package com.liu.month8.d0814.proxy_jdk1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liucong
 * @ClassName: MyInvocationHandler
 * @Description:
 * @date: 2020/8/14 15:03
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object proxy;

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Methods.method1();
        method.invoke(this.proxy, args);
        Methods.method2();
        return null;
    }
}
