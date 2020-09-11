package com.liu.month8.d0813.data;

/**
 * ClassName: Node <br/>
 * Description: <br/>
 * date: 2020/8/13 15:47<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
