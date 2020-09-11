package com.liu.month8.d0814.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 被观察者，微信公众号服务
 * @auther: liucong
 * @date: 2020/8/14 10:56
 * @return:
 */
public class WechatServer implements Observerable {
    private List<Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (!list.isEmpty())
            list.remove(o);
    }

    @Override
    public void notifyObserver() {
        list.forEach(o -> {
            o.update(message);
        });
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微服务更新消息：" + s);
        // 消息更新，通知所有观察者
        notifyObserver();
    }
}
