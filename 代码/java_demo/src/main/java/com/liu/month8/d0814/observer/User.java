package com.liu.month8.d0814.observer;

/**
 * @author liucong
 * @ClassName: User
 * @Description: 观察者
 * @date: 2020/8/14 11:03
 */
public class User implements Observer {
    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + "收到推送消息：" + message);
    }
}
