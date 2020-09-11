package com.liu.month8.d0813.model;

/**
 * ClassName: Singleton2 <br/>
 * Description: <br/>
 * date: 2020/8/13 16:57<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Singleton2 {
    // 懒汉
    private static Singleton2 s;

    private Singleton2() {}

    public synchronized static Singleton2 getInstance() {
        return s == null ? new Singleton2() : s;
    }
}
