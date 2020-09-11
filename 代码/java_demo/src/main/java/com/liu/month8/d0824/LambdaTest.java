package com.liu.month8.d0824;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liucong
 * @ClassName: LambdaTest
 * @Description:
 * @date: 2020/8/24 17:58
 */
public class LambdaTest {
    private List<String> list = new ArrayList<>();

    @Test
    public void test01() {
        list.add("Lisa");
        list.add("Lida");
        list.add("James");
        int i = 1;
        list.forEach(str -> {
            System.out.println(i);
        });
        System.out.println("fff");
    }
}
