package com.liu.month8.d0814.blog;

/**
 * @author liucong
 * @ClassName: IObserver
 * @Description: 观察者接口
 * @date: 2020/8/14 11:52
 */
public interface IObserver {
    // 当被观察者发布文章就会调用此方法
    void update(String name, String msg);
}
