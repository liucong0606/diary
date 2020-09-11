package com.liu.month9.d0901;

import org.junit.Test;

import java.util.*;

/**
 * @author liucong
 * @ClassName: SetTest
 * @Description:
 * @date: 2020/9/1 16:29
 */
public class SetTest {
    @Test
    public void test01() {
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.forEach(s -> {
            if (s.equals("c")) {
                set.add("d");
            }
        });
        for (String s : set) {
            System.out.println(s);
        }
    }
}
