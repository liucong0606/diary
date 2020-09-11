package com.liu.month8.d0817.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liucong
 * @ClassName: MyHandler
 * @Description:
 * @date: 2020/8/17 9:31
 */
public class MyHandler implements InvocationHandler {
    private Object c;

    public void setC(Object c) {
        this.c = c;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(c, args);
        if (method.getName().equals("begin"))
        {
            Methods.beginCam();
            Methods.loadWindow();
        } else {
            Methods.endCam();
            Methods.end();
        }
        return null;
    }
}
