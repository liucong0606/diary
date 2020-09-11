package com.liu.month8.d0810.annotate;

import java.lang.annotation.*;

/**
 * ClassName: IFruit <br/>
 * Description: <br/>
 * date: 2020/8/10 15:30<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IFruit {
    String fruitName() default "苹果";
}
