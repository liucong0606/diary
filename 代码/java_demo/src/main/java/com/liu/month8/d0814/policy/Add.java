package com.liu.month8.d0814.policy;

/**
 * ClassName: Add <br/>
 * Description: <br/>
 * date: 2020/8/14 9:11<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Add implements Counter {
    @Override
    public double getResult(double num1, double num2) {
        return num1 + num2;
    }
}
