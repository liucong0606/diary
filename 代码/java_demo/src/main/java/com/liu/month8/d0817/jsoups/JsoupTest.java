package com.liu.month8.d0817.jsoups;

import org.junit.Test;

import java.util.List;

/**
 * @author liucong
 * @ClassName: JsoupTest
 * @Description:
 * @date: 2020/8/17 14:09
 */
public class JsoupTest {
    @Test
    public void test01() {
        String url = "http://book.zongheng.com/chapter/1016839/61764784.html";
        String title = ZongHengUtils.getTitle(url);
        System.out.println(title);
    }

    @Test
    public void test02() {
        String url = "http://book.zongheng.com/chapter/1016839/61764784.html";
        String title = ZongHengUtils.getTitle(url);
        List text = ZongHengUtils.getText(url);
        System.out.println(title);
        text.forEach(System.out::println);
        System.out.println(ZongHengUtils.getNextUrl(url));
    }

    /**
     * @Description: 纵横
     * @auther: liucong
     * @date: 2020/8/19 9:12
     * @return:
     */
    @Test
    public void test03() {
        String url = "http://book.zongheng.com/chapter/1016839/61764784.html";
        ZongHengUtils.reading(url);
    }

    /**
     * @Description: 彼岸图库
     * @auther: liucong
     * @date: 2020/8/19 9:12
     * @return:
     */
    @Test
    public void test04() {
        ImgReptile.download();
    }
}
