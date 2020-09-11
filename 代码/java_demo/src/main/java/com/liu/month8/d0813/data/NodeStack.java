package com.liu.month8.d0813.data;

/**
 * ClassName: NodeStack <br/>
 * Description: <br/>
 * date: 2020/8/13 15:42<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class NodeStack<T> {
    private Node<T> top = null;

    // 栈空
    public boolean isEmpty() {
        return null == top;
    }

    // 压栈
    public boolean push(T obj) {
        // 链表栈不需要判断栈满
        Node<T> node = new Node<>(obj);
        node.setNext(top);
        top = node;
        return true;
    }

    // 出栈
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T tmp = top.getData();
        top = top.getNext();
        return tmp;
    }

    // 取栈顶
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getData();
    }
}
