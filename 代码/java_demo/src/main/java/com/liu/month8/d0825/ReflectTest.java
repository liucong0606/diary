package com.liu.month8.d0825;

import com.liu.month8.d0825.pojo.Good;
import com.liu.month8.d0825.utils.BaseUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liucong
 * @ClassName: ReflectTest
 * @Description:
 * @date: 2020/8/25 9:41
 */
public class ReflectTest {
    @Test
    public void test01() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("name", "男士格子衫");
        map.put("typeId", 1);
        map.put("remark", "最新款式，韩式风格");
        map.put("aaa", "最新款式，韩式风格");
        Good good = BaseUtil.populate(map, Good.class);
        System.out.println(good);
    }

    @Test
    public void test02() {
        Good g = new Good(1002, "男士双肩包", 1, "旅行必备");
        Map map = BaseUtil.Object2Map(g);
        Set keys = map.keySet();
        keys.forEach(key -> {
            System.out.println(key + ":\t" + map.get(key));
        });
    }
}
