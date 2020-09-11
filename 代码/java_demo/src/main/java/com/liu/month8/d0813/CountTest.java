package com.liu.month8.d0813;

import com.liu.month8.d0813.factory.CountFactory;
import com.liu.month8.d0813.factory.Counter;
import org.junit.Test;

/**
 * ClassName: CountTest <br/>
 * Description: <br/>
 * date: 2020/8/13 17:13<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class CountTest {
    @Test
    public void test01() {
        CountFactory cf = new CountFactory();
        Counter c = cf.getCounter('+');
        double result = c.getResult(1, 5);
        System.out.println(result);
    }
}
