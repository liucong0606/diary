package com.liu.month8.d0817.proxy_cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liucong
 * @ClassName: MyInterceptor
 * @Description:
 * @date: 2020/8/17 9:49
 */
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = methodProxy.invokeSuper(o, objects);
        if (method.getName().equals("begin")) {
            Methods.beginCam();
            Methods.loadWindow();
        } else {
            Methods.endCam();
            Methods.end();
        }
        return obj;
    }
}
