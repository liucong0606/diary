package com.liu.month8.d0814.proxy_jdk;

/**
 * @author liucong
 * @ClassName: GunDog
 * @Description:
 * @date: 2020/8/14 14:37
 */
public class GunDog implements IDog {
    @Override
    public void run() {
        System.out.println("猎狗在跑...");
    }
}
