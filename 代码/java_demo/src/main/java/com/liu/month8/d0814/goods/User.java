package com.liu.month8.d0814.goods;

/**
 * @author liucong
 * @ClassName: User
 * @Description:
 * @date: 2020/8/14 11:39
 */
public class User implements Observer {
    private String name;
    private String msg;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.msg = message;
        read();
    }

    public void read() {
        System.out.println("收到短信：" + this.msg);
    }
}
