package com.liu.month8.d0814.proxy_jdk;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: JDKProxyTest
 * @Description:
 * @date: 2020/8/14 14:46
 */
public class JDKProxyTest {
    @Test
    public void test01() {
        IDog dog = new GunDog();
        IDog target = (IDog) MyProxyFactory.getTarget(dog);
        target.run();
    }
}
