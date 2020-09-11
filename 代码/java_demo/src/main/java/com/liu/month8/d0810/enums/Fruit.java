package com.liu.month8.d0810.enums;

import com.liu.month8.d0810.annotate.IFruit;

/**
 * ClassName: Fruit <br/>
 * Description: <br/>
 * date: 2020/8/10 15:32<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Fruit {
    @IFruit(fruitName = "香蕉")
    private String fruitName;

    public String getFruitName() {
        return fruitName;
    }
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
}
