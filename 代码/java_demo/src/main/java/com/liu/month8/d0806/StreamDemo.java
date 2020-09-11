package com.liu.month8.d0806;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: StreamDemo <br/>
 * Description: <br/>
 * date: 2020/8/6 17:31<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class StreamDemo {
    private List<String> names = new ArrayList<String>();

    public StreamDemo() {
        setData();
    }

    /**
     * @Description: 遍历集合
     * @auther: liucong
     * @date: 2020/8/6 17:34
     * @return:
     */
    @Test
    public void test01() {
        names.forEach(name -> {
            this.print(name);
        });
    }

    /**
     * @Description: 方法引用
     * @auther: liucong
     * @date: 2020/8/6 17:41
     * @return:
     */
    @Test
    public void test02() {
        names.forEach(this::print);
    }

    /**
     * @Description: 去重后遍历
     * @auther: liucong
     * @date: 2020/8/6 17:57
     * @return:
     */
    @Test
    public void test03() {
        names.stream().distinct().forEach(this::print);
    }

    /**
     * @Description: 排序后遍历
     * @auther: liucong
     * @date: 2020/8/7 14:17
     * @return:
     */
    @Test
    public void test04() {
        names.stream().sorted((s1, s2) -> {
            int num1 = s1.length() - s2.length();
            int num2 = num1 == 0 ? s1.compareTo(s2) : num1;
            return num2;
        }).forEach(this::print);
    }

    /**
     * @Description: 集合合并
     * @auther: liucong
     * @date: 2020/8/7 14:47
     * @return:
     */
    @Test
    public void test05() {
        List<String> names = new ArrayList<String>();
        names.add("王者农药");
        names.add("狗熊联盟");
        names.add("企鹅碰碰车");

        Stream.concat(this.names.stream(), names.stream()).collect(Collectors.toList()).forEach(this::print);
    }

    /**
     * @Description: 单行打印姓名
     * @auther: liucong
     * @date: 2020/8/6 17:47
     * @return:
     */
    private void print(String name) {
        System.out.print(name + "\t");
    }

    /**
     * @Description: 给集合添加数据
     * @auther: liucong
     * @date: 2020/8/6 17:47
     * @return:
     */
    private void setData() {
        names.add("Camila");
        names.add("J.Fla");
        names.add("Lisa");
        names.add("Lisa");
        names.add("Paul");
        names.add("Jack");
        names.add("冯羿");
        names.add("冯羿");
    }
}
