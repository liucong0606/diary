package com.liu.month8.d0813.data;

/**
 * ClassName: ArrayQueue <br/>
 * Description: <br/>
 * date: 2020/8/13 16:10<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class ArrayQueue<T> {
    private T[] data;   // 队列
    private int maxSize;    // 队列长度
    public int top;

    // 初始化队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        data = (T[]) new Object[maxSize];
        top = -1;
    }

    // 空队列
    public boolean isEmpty() {
        return data[0] == null;
    }

    // 满队列
    public boolean isFull() {
        return data[maxSize - 1] != null;
    }

    // 入队
    public boolean push(T obj) {
        if (isFull()) {
            return false;
        }
        top++;
        data[top] = obj;
        return true;
    }

    // 出队
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T obj = data[0];
        // 右边往左边移
        for (int i = 0; i < top - 1; i++) {
            data[i] = data[i + 1];
        }
        top--;
        return obj;
    }
}
