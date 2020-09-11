package com.liu.month8.d0811;

import org.junit.Test;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: HashMapTest <br/>
 * Description: <br/>
 * date: 2020/8/11 11:05<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class HashMapTest {
    @Test
    public void test01() {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("", "");
        Hashtable hTable = new Hashtable();
        hTable.put("name", "liu");
    }
}
