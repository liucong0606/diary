package com.liu.month8.d0814.blog;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: BlogTest
 * @Description:
 * @date: 2020/8/14 13:32
 */
public class BlogTest {
    /**
     * @Description: 测试博客发布文章，订阅文章
     * @auther: liucong
     * @date: 2020/8/14 13:40
     * @return:
     */
    @Test
    public void test01() {
        BlogUser userCamila = new BlogUser("Camila");
        BlogUser userJFla = new BlogUser("J.FLa");
        BlogUser userLisa = new BlogUser("Lisa");

        userCamila.follow(userJFla);
        userCamila.follow(userLisa);
        userJFla.follow(userCamila);
        userJFla.follow(userLisa);

        userCamila.pushEssay("Chinese是世界上最好的语言");
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        userJFla.pushEssay("Java未来前景");
    }
}
