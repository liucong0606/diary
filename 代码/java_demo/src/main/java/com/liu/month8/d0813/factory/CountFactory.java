package com.liu.month8.d0813.factory;

/**
 * ClassName: CountFactory <br/>
 * Description: <br/>
 * date: 2020/8/13 17:10<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class CountFactory {
    public Counter getCounter(char sign) {
        Counter c = null;
        switch (sign) {
            case '+':
                c = new Add();
                break;
            case '-':
                c = new Sub();
                break;
            case '*':
                c = new Mul();
                break;
            case '/':
                c = new Div();
                break;
            default:
                try {
                    throw new Exception("符号不正确");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        return c;
    }
}
