package com.liu.month8.d0814.goods;

/**
 * @Description: 抽象被观察者接口
 * @auther: liucong
 * @date: 2020/8/14 10:48
 * @return: 
 */
public interface Observerable {
    // 添加观察者
    void buyGoods(Observer o);
    // 通知观察者
    void notifyObserver();
}
