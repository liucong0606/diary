package com.liu.month8.d0813;

import com.liu.month8.d0813.data.ArrayQueue;
import com.liu.month8.d0813.data.ArrayStack;
import com.liu.month8.d0813.data.NodeStack;
import org.junit.Test;

/**
 * ClassName: DataTest <br/>
 * Description: <br/>
 * date: 2020/8/13 15:30<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class DataTest {
    /**
     * @Description: 测试数组栈
     * @auther: liucong
     * @date: 2020/8/13 15:30
     * @return:
     */
    @Test
    public void test01() {
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);
        for (int i = 0; i < 4; i++) {
            System.out.print(as.pop() + "\t");
        }
    }

    @Test
    public void test02() {
        NodeStack<String> ns = new NodeStack<>();
        ns.push("Java");
        ns.push("C#");
        ns.push("Unity");
        ns.push("Python");
        for (int i = 0; i < 4; i++) {
            System.out.print(ns.pop() + "\t");
        }
    }

    @Test
    public void test03() {
        ArrayQueue<String> aq = new ArrayQueue<>(5);
        aq.push("林黛玉");
        aq.push("薛宝钗");
        aq.push("贾宝玉");
        aq.push("惜春");

        for (int i = 0; i < 4; i++) {
            System.out.print(aq.pop() + "\t");
        }
    }
}
