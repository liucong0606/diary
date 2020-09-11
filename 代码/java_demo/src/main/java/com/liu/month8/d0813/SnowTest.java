package com.liu.month8.d0813;

import com.liu.month8.d0813.utils.IdWorker;
import org.junit.Test;

/**
 * ClassName: SnowTest <br/>
 * Description: <br/>
 * date: 2020/8/13 10:59<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class SnowTest {
    @Test
    public void test01() {
        IdWorker idWorker = new IdWorker(31, 12,12);
        System.out.println(idWorker.nextId());
    }
}
