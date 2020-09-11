package com.liu.month8.d0814.proxy_cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liucong
 * @ClassName: MyMethodInterceptor
 * @Description:
 * @date: 2020/8/14 15:40
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Methods.method1();
        Object proxy = methodProxy.invokeSuper(o, objects);
        Methods.method2();
        return proxy;
    }
}
