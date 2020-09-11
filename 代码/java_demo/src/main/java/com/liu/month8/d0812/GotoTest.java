package com.liu.month8.d0812;

import org.junit.Test;

/**
 * ClassName: GotoTest <br/>
 * Description: <br/>
 * date: 2020/8/12 14:10<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class GotoTest {
    /**
     * @Description: 测试 Java 中的 goto 语法
     * @auther: liucong
     * @date: 2020/8/12 14:13
     * @return:
     */
    @Test
    public void test01() {
        柳聪:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break 柳聪;
                }
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
