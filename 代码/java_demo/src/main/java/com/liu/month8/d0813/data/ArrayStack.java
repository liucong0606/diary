package com.liu.month8.d0813.data;

/**
 * ClassName: ArrayStack <br/>
 * Description: 底层为数组的栈<br/>
 * date: 2020/8/13 15:16<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class ArrayStack<T> {
    private T[] data;   // 栈
    public int maxSize;    // 栈的最大长度
    public int top;    // 栈顶

    // 初始化栈
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        data = (T[]) new Object[maxSize];
        this.top = -1;   // 默认-1，代表栈为空
    }

    // 是否栈为空
    public boolean isEmpty() {
        return this.top == -1;
    }

    // 是否栈满
    public boolean isFull() {
        return this.maxSize -1 == top;
    }

    // 压栈
    public boolean push(T obj) {
        if (isFull()) {
            return false;
        }
        this.top++;
        data[top] = obj;
        return true;
    }

    // 弹栈
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T obj = data[top];
        data[top] = null;
        top--;
        return obj;
    }
}
