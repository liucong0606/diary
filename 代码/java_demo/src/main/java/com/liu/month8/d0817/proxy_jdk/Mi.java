package com.liu.month8.d0817.proxy_jdk;

/**
 * @author liucong
 * @ClassName: Mi
 * @Description:
 * @date: 2020/8/17 9:21
 */
public class Mi implements Computer {
    @Override
    public void begin() {
        System.out.println("小米电脑正在开机");
    }

    @Override
    public void end() {
        System.out.println("小米电脑正在关机");
    }
}
