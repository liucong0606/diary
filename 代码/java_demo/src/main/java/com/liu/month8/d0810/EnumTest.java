package com.liu.month8.d0810;

import com.liu.month8.d0810.enums.HeroSkill;
import org.junit.Test;
import java.util.Arrays;

/**
 * ClassName: EnumTest <br/>
 * Description: <br/>
 * date: 2020/8/10 15:14<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class EnumTest {
    @Test
    public void test01() {
        Arrays.asList(new HeroSkill[] {
                        HeroSkill.Q,
                        HeroSkill.W,
                        HeroSkill.E,
                        HeroSkill.R
                }).forEach(System.out::println);
    }
}
