package com.liu.month8.d0814.proxy_jdk1;

/**
 * @author liucong
 * @ClassName: Singer
 * @Description:
 * @date: 2020/8/14 15:00
 */
public class Singer implements ISinger {
    private String name;

    public Singer(String name) {
        this.name = name;
    }
    @Override
    public void sing() {
        System.out.println(name + "正在唱歌...");
    }
}
