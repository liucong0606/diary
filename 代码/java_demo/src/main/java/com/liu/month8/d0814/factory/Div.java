package com.liu.month8.d0814.factory;

/**
 * ClassName: Div <br/>
 * Description: <br/>
 * date: 2020/8/14 9:34<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Div implements Counter {
    @Override
    public double getResult(double num1, double num2) {
        return num1 / num2;
    }
}
