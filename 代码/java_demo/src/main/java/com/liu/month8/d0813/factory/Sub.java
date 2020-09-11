package com.liu.month8.d0813.factory;

/**
 * ClassName: Sub <br/>
 * Description: <br/>
 * date: 2020/8/13 17:09<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Sub implements Counter {
    @Override
    public double getResult(int num1, int num2) {
        return num1 - num2;
    }
}
