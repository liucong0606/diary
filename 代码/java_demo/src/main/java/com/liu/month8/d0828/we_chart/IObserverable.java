package com.liu.month8.d0828.we_chart;

/**
 * @author liucong
 * @ClassName: IOberverable
 * @Description: 被观察者
 * @date: 2020/8/28 9:33
 */
public interface IObserverable {
    void add(IObserver obj);

    void remove(IObserver obj);

    void notice();
}
