package com.liu.month8.d0814.policy;

/**
 * ClassName: Context <br/>
 * Description: <br/>
 * date: 2020/8/14 9:13<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Context {
    private Counter counter;

    public Context(Counter counter) {
        this.counter = counter;
    }

    public double executeCounter(double num1, double num2) {
        return counter.getResult(num1, num2);
    }
}
