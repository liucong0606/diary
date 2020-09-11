package com.liu.month8.d0828.we_chart;

import org.junit.Test;

import java.util.UUID;

/**
 * @author liucong
 * @ClassName: UserTest
 * @Description:
 * @date: 2020/8/28 9:56
 */
public class UserTest {
    @Test
    public void test01() {
        User userCamila = new User(UUID.randomUUID().toString(), "Camila");
        User userJFLa = new User(UUID.randomUUID().toString(), "J.Fla");
        User userLisa = new User(UUID.randomUUID().toString(), "Lisa");
        userCamila.add(userJFLa);
        userCamila.add(userLisa);
        userCamila.sendMsg2All("天气转凉，亲们注意保暖~~~");
    }
}
