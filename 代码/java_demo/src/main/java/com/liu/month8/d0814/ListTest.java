package com.liu.month8.d0814;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: ListTest <br/>
 * Description: <br/>
 * date: 2020/8/14 10:30<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class ListTest {
    /**
     * @Description: 使ArrayList线程安全
     * @auther: liucong
     * @date: 2020/8/14 10:42
     * @return:
     */
    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Unity");
        list.add("Python");
        List<String> strList = Collections.synchronizedList(list);
        strList.forEach(System.out::println);
    }
}
