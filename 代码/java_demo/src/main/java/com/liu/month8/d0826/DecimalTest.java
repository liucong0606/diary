package com.liu.month8.d0826;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liucong
 * @ClassName: DecimalTest
 * @Description:
 * @date: 2020/8/26 9:02
 */
public class DecimalTest {
    /**
     * @Description: 丢失精度
     * @auther: liucong
     * @date: 2020/8/26 9:06
     * @return:
     */
    @Test
    public void test01() {
        double num1 = 148;
        double num2 = 0.14;
        System.out.println(num1 * num2);
    }

    /**
     * @Description: 使用 BigDecimal 来解决丢失精度问题
     * @auther: liucong
     * @date: 2020/8/26 9:10
     * @return:
     */
    @Test
    public void test02() {
        double num1 = 148;
        double num2 = 0.14;
        BigDecimal d1 = new BigDecimal(Double.toString(num1));
        BigDecimal d2 = new BigDecimal(Double.toString(num2));
        System.out.println(d1.multiply(d2).doubleValue());
    }

    @Test
    public void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("战士", 26);
        map.put("射手", 29);
        map.put("法师", 50);
        map.put("坦克", 31);
        map.put("刺客", 21);
        Set<String> keys = map.keySet();
        keys.forEach(key -> {
            Integer value = map.get(key);
            String s = Math.floor((double)value / 157 * 1000) / 10 + "%";
            System.out.println(s);
        });
    }
}
