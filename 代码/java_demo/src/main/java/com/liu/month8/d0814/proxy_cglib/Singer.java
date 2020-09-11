package com.liu.month8.d0814.proxy_cglib;

/**
 * @author liucong
 * @ClassName: Singer
 * @Description:
 * @date: 2020/8/14 15:36
 */
public class Singer {
    private String name;

    public Singer() {}

    public Singer(String name) {
        this.name = name;
    }

    public void sing() {
        System.out.println(this.name + "在唱歌...");
    }

    public void dance() {
        System.out.println(this.name + "在跳舞...");
    }
}
