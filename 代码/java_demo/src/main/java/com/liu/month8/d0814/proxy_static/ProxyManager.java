package com.liu.month8.d0814.proxy_static;

/**
 * @author liucong
 * @ClassName: ProxyManager
 * @Description: 静态代理类
 * @date: 2020/8/14 14:28
 */
public class ProxyManager implements ISinger {
    private ISinger singer;

    public ProxyManager() {}

    public ProxyManager(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("唱歌前准备工作");
        singer.sing();
        System.out.println("唱歌后善后");
    }
}
