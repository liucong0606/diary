package com.liu.month8.d0813;

import org.junit.Test;

/**
 * ClassName: SwitchTest <br/>
 * Description: <br/>
 * date: 2020/8/13 11:46<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class SwitchTest {
    @Test
    public void test01() {
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }

    /**
     * jad工具可以反编译  jad -p SwitchDemoString.class > SwitchDemoString.java
     * @Description: switch 先通过hashcode判断，再通过equals判断
     * @auther: liucong
     * @date: 2020/8/13 11:49
     * @return:
     */
    @Test
    public void test02() {
        String s = "重地";
        switch (s) {
            case "通话":
                System.out.println("通话");
                break;
            default:
                System.out.println("其他");
                break;
        }
    }
}
