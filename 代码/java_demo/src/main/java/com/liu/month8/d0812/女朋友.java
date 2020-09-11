package com.liu.month8.d0812;

/**
 * ClassName: 女朋友 <br/>
 * Description: <br/>
 * date: 2020/8/12 9:04<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class 女朋友 {
    private String 姓名;
    private int 年龄;
    private String 性别;

    public String 获取姓名() {
        return 姓名;
    }

    public void 设置姓名(String 姓名) {
        this.姓名 = 姓名;
    }

    public int 获取年龄() {
        return 年龄;
    }

    public void 设置年龄(int 年龄) {
        this.年龄 = 年龄;
    }

    public String 获取性别() {
        return 性别;
    }

    public void 设置性别(String 性别) {
        this.性别 = 性别;
    }

    @Override
    public String toString() {
        return "女朋友{" +
                "姓名='" + 姓名 + '\'' +
                ", 年龄=" + 年龄 +
                ", 性别='" + 性别 + '\'' +
                '}';
    }
}
