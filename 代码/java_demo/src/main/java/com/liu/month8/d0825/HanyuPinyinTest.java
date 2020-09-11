package com.liu.month8.d0825;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author liucong
 * @ClassName: HanyuPinyinTest
 * @Description:
 * @date: 2020/8/25 14:50
 */
public class HanyuPinyinTest {
    private HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    @Test
    public void test01() {
        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
        // format.setToneType(HanyuPinyinToneType.WITH_TONE_NUMBER);
        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        try {
            String[] s = PinyinHelper.toHanyuPinyinStringArray('女', format);
            System.out.println(Arrays.toString(s));
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
    }

    @Test
    public void test02() {

    }
}
