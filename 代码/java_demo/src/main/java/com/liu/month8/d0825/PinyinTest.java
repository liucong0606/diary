package com.liu.month8.d0825;

import com.liu.month8.d0825.utils.BaseUtil;
import org.junit.Test;

/**
 * @author liucong
 * @ClassName: PinyinTest
 * @Description:
 * @date: 2020/8/25 11:50
 */
public class PinyinTest {
    /**
     * @Description: 测试字符串全拼
     * @auther: liucong
     * @date: 2020/8/25 13:34
     * @return:
     */
    @Test
    public void test01() {
        String word = BaseUtil.getSpellWord("柳聪");
        System.out.println(word);
    }

    /**
     * @Description: 测试汉字首字母
     * @auther: liucong
     * @date: 2020/8/25 13:35
     * @return:
     */
    @Test
    public void test02() {
        System.out.println(BaseUtil.getFirstWord('柳'));
        System.out.println(BaseUtil.getFirstWord("柳"));
    }

    @Test
    public void test03() {
        System.out.println(BaseUtil.getFirstWord4ManyWord("柳聪"));
    }
}
