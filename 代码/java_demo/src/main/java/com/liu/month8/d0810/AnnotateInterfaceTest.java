package com.liu.month8.d0810;

import com.liu.month8.d0810.annotate.IFruit;
import com.liu.month8.d0810.enums.Fruit;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * ClassName: AnnotateInterfaceTest <br/>
 * Description: <br/>
 * date: 2020/8/10 15:28<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class AnnotateInterfaceTest {
    @Test
    public void test01() throws NoSuchFieldException {
        Fruit fruit = new Fruit();
        Class<? extends Fruit> aClass = fruit.getClass();
        Field fruitName = aClass.getDeclaredField("fruitName");
        fruitName.setAccessible(true);
        boolean isExist = fruitName.isAnnotationPresent(IFruit.class);
        if (isExist) {
            IFruit iFruit = fruitName.getAnnotation(IFruit.class);
            System.out.println(iFruit.fruitName());
        }
    }
}
