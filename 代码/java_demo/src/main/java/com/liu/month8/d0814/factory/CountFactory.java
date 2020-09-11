package com.liu.month8.d0814.factory;

/**
 * ClassName: CountFactory <br/>
 * Description: <br/>
 * date: 2020/8/14 9:35<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class CountFactory {
    public static Counter getAdd() {
        return new Add();
    }

    public static Counter getSub() {
        return new Sub();
    }

    public static Counter getMul() {
        return new Mul();
    }

    public static Counter getDiv() {
        return new Div();
    }
}
