package com.liu.month9.d0902;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: QuestionTest
 * @Description:
 * @date: 2020/9/2 16:43
 */
public class QuestionTest {
    /**
     * @Description:
     *          *
     *          **
     *          ***
     *          ****
     * @auther: liucong
     * @date: 2020/9/2 16:43
     * @return:
     */
    @Test
    public void test01() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * @Description:
     *          *********
     *          *******
     *          *****
     *          ***
     *          *
     * @auther: liucong
     * @date: 2020/9/2 16:45
     * @return:
     */
    @Test
    public void test02() {
        for (int i = 5; i >= 1; i--) {
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
