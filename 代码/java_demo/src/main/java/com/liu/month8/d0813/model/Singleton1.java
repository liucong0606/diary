package com.liu.month8.d0813.model;

/**
 * ClassName: Singleton <br/>
 * Description: <br/>
 * date: 2020/8/13 16:53<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Singleton1 {
    // 饿汉
    private static Singleton1 s = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return s;
    }
}
