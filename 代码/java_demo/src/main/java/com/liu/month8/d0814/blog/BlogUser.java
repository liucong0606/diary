package com.liu.month8.d0814.blog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liucong
 * @ClassName: BlogUser
 * @Description: 博客用户 （既是观察者，又是被观察者）
 * @date: 2020/8/14 11:56
 */
public class BlogUser implements IObserverable, IObserver {
    private String msg; // 发布的文章
    private String name;    // 用户名
    // 用来存储关注你的观察者，Collections.synchronizedList()保证线程安全
    private List<IObserver> list = Collections.synchronizedList(new ArrayList<>());

    public BlogUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String name, String msg) {
        System.out.println(this.name + "：一条消息：" + name + "发布了一篇文章，" + msg);
    }

    @Override
    public void follow(IObserver user) {
        list.add(user);
    }

    @Override
    public void unFollow(IObserver user) {
        if (!list.isEmpty())
            list.remove(user);
    }

    @Override
    public void notifyObserver() {
        list.forEach(user -> {
            user.update(this.name, this.msg);
        });
    }

    /**
     * @Description: 发布文章
     * @auther: liucong
     * @date: 2020/8/14 13:59
     * @return:
     */
    public void pushEssay(String msg) {
        System.out.println(this.name + "发布了一篇文章：" + msg);
        this.msg = msg;
        // 文章发布完成就通知观察者
        notifyObserver();
    }
}
