package com.liu.month8.d0826;

import com.liu.month8.d0826.utils.MathUtil;
import org.junit.Test;

/**
 * @author liucong
 * @ClassName: MathTest
 * @Description:
 * @date: 2020/8/26 9:46
 */
public class MathTest {
    @Test
    public void test01() {
        double num1 = 12;
        double num2 = 5;
        System.out.println(MathUtil.add(num1, num2));
        System.out.println(MathUtil.sub(num1, num2));
        System.out.println(MathUtil.mul(num1, num2));
        System.out.println(MathUtil.div(num1, num2));
    }

    @Test
    public void test02() {
        int[] arr = {2, 6, 7, 9, 4, 8};
        int sum = 36;
        int precision = 2;
        double t = 0;
        for (int i = 0; i < arr.length; i++) {
            double s = MathUtil.getPercentValue(arr, sum, i, precision);
            System.out.println(s);
            // String substring = s.substring(0, s.length() - 1);
            // t = MathUtil.add(t, Double.valueOf(substring));
            t = MathUtil.add(t, s);
        }
        System.out.println("总和：" + t);
    }

}
