package com.liu.month8.d0817;

import com.liu.month8.d0817.enums.Stu;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author liucong
 * @ClassName: ReflexTest
 * @Description:
 * @date: 2020/8/17 10:49
 */
public class ReflexTest {
    @Test
    public void test01() throws Exception {
        Constructor<Stu> declaredConstructor = Stu.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Stu stu = declaredConstructor.newInstance();
        System.out.println(stu);
    }
}
