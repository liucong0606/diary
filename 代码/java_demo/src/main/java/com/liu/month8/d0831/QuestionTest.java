package com.liu.month8.d0831;

import org.junit.Test;

/**
 * @author liucong
 * @ClassName: QuestionTest
 * @Description:
 * @date: 2020/8/31 17:34
 */
public class QuestionTest {
    /**
     * @Description:
     *      *****       0 空格
     *       *****      1 空格
     *        *****     2 空格
     *         *****    3 空格
     * @auther: liucong
     * @date: 2020/8/31 17:35
     * @return:
     */
    @Test
    public void test01() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * @Description:
     *          *****   5   2 空格
     *         *******  7   1 空格
     *        ********* 9   0 空格
     * @auther: liucong
     * @date: 2020/8/31 17:43
     * @return:
     */
    @Test
    public void test02() {
        for (int i = 5; i <= 9; i += 2) {
            for (int j = 0; j < (9 - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
