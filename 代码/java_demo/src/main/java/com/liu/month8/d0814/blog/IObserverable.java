package com.liu.month8.d0814.blog;

/**
 * @author liucong
 * @ClassName: IObserverable
 * @Description: 被观察者接口
 * @date: 2020/8/14 11:50
 */
public interface IObserverable {
    // 关注
    void follow(IObserver user);

    // 取消关注
    void unFollow(IObserver user);

    // 通知观察者
    void notifyObserver();
}
