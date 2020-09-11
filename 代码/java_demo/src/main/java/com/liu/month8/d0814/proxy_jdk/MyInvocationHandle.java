package com.liu.month8.d0814.proxy_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liucong
 * @ClassName: MyInvocationHandle
 * @Description:
 * @date: 2020/8/14 14:40
 */
public class MyInvocationHandle implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtils.method1();
        method.invoke(target, args);
        DogUtils.method2();
        return null;
    }
}
