package com.liu.month8.d0827;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author liucong
 * @ClassName: MapTest
 * @Description:
 * @date: 2020/8/27 16:22
 */
public class MapTest {
    /**
     * @Description: 测试 Map数组
     * @auther: liucong
     * @date: 2020/8/27 16:32
     * @return:
     */
    @Test
    public void test01() {
        Map[] maps = new HashMap[3];
        init(maps);
        print(maps);
    }

    private void print(Map[] maps) {
        System.out.println("密码1\t\t\t\t\t\t\t\t\t密码2\t\t\t\t\t\t\t\t\t密码3");
        for (Map map : maps) {
            Set keys = map.keySet();
            keys.forEach(key -> {
                System.out.print(map.get(key) + "\t");
            });
            System.out.println();
        }
    }

    private void init(Map[] maps) {
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap();
        }
        for (Map map : maps) {
            map.put("num1", UUID.randomUUID().toString());
            map.put("num2", UUID.randomUUID().toString());
            map.put("num3", UUID.randomUUID().toString());
        }
    }
}
