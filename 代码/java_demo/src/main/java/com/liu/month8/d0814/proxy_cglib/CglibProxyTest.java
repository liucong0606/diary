package com.liu.month8.d0814.proxy_cglib;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

/**
 * @author liucong
 * @ClassName: CglibProxyTest
 * @Description:
 * @date: 2020/8/14 15:48
 */
public class CglibProxyTest {
    @Test
    public void test01() {
        Enhancer e = new Enhancer();
        e.setSuperclass(Singer.class);
        e.setCallback(new MyMethodInterceptor());
        Singer singer = (Singer) e.create(new Class[]{String.class}, new Object[] {"Camila"});
        singer.sing();
        System.out.println("-_-_-_-_-_-_-_-_");
        singer.dance();
    }
}
