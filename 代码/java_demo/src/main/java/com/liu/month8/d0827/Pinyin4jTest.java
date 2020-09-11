package com.liu.month8.d0827;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: Pinyin4jTest
 * @Description:
 * @date: 2020/8/27 15:20
 */

public class Pinyin4jTest {
    @Test
    public void test01() {
        String[] s = PinyinHelper.toHanyuPinyinStringArray('女');
        System.out.println(Arrays.toString(s));
    }

    @Test
    public void test02() throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        String[] s = PinyinHelper.toHanyuPinyinStringArray('女', format);
        System.out.println(Arrays.toString(s));
    }
}
