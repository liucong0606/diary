package com.liu.month8.d0814.proxy_static;

/**
 * @author liucong
 * @ClassName: Singer
 * @Description:
 * @date: 2020/8/14 14:26
 */
public class Singer implements ISinger {
    private String name;

    public Singer(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println(this.name + "正在唱歌...");
    }
}
