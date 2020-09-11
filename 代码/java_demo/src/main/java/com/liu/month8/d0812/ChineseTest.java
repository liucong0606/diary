package com.liu.month8.d0812;

import org.junit.Test;

/**
 * ClassName: Test <br/>
 * Description: <br/>
 * date: 2020/8/12 9:04<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class ChineseTest {
    @Test
    public void test01() {
        女朋友 刘亦菲 = new 女朋友();
        刘亦菲.设置姓名("刘亦菲");
        刘亦菲.设置性别("女");
        刘亦菲.设置年龄(30);
        打印(刘亦菲);
    }

    private void 打印(女朋友 女) {
        System.out.print(女.获取姓名() + "\t" + 女.获取性别() + "\t" + 女.获取年龄());
    }
}

