package com.liu.month8.d0814.observer;

/**
 * ClassName: Observer
 * Description: 抽象观察者
 * date: 2020/8/14 10:51
 * @author liucong
 */
public interface Observer {
    // 当被观察者调用通知方法时，观察者的update方法会被调用
    void update(String message);
}
