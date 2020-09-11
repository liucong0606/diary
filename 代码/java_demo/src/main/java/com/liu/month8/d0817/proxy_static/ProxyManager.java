package com.liu.month8.d0817.proxy_static;

/**
 * @author liucong
 * @ClassName: proxy
 * @Description:
 * @date: 2020/8/17 9:22
 */
public class ProxyManager implements Computer {
    private Computer c;

    public ProxyManager(Computer c) {
        this.c = c;
    }

    @Override
    public void begin() {
        c.begin();
        Methods.beginCam();
        Methods.loadWindow();
    }

    @Override
    public void end() {
        c.end();
        Methods.endCam();
        Methods.end();
    }
}
