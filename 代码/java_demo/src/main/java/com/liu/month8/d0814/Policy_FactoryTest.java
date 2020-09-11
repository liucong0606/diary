package com.liu.month8.d0814;

import com.liu.month8.d0814.factory.CountFactory;
import com.liu.month8.d0814.factory.Counter;
import com.liu.month8.d0814.goods.InternetShopServer;
import com.liu.month8.d0814.observer.Observer;
import com.liu.month8.d0814.observer.User;
import com.liu.month8.d0814.observer.WechatServer;
import com.liu.month8.d0814.policy.Add;
import com.liu.month8.d0814.policy.Context;
import org.junit.Test;

/**
 * ClassName: Policy_FactoryTest <br/>
 * Description: <br/>
 * date: 2020/8/14 9:17<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public class Policy_FactoryTest {
    /**
     * @Description: 工厂测试
     * @auther: liucong
     * @date: 2020/8/14 10:02
     * @return:
     */
    @Test
    public void test01() {
        Counter add = CountFactory.getAdd();
        System.out.println(add.getResult(1, 6));
    }

    /**
     * @Description: 策略测试
     * @auther: liucong
     * @date: 2020/8/14 10:02
     * @return:
     */
    @Test
    public void test02() {
        Context context = new Context(new Add());
        System.out.println(context.executeCounter(3, 5));
    }

    /**
     * @Description: 观察者测试
     * @auther: liucong
     * @date: 2020/8/14 11:06
     * @return:
     */
    @Test
    public void test03() {
        // 启动公众号服务
        WechatServer server = new WechatServer();

        Observer userCamila = new User("Camila");
        Observer userLisa = new User("Lisa");
        Observer userJFla = new User("J.Fla");
        // 公众号注册的用户
        server.registerObserver(userCamila);
        server.registerObserver(userLisa);
        server.registerObserver(userJFla);

        // 公众号发布消息，用户会自动订阅消息
        server.setInfomation("Chinese是世界上最好的语言");
    }

    @Test
    public void test04() {
        InternetShopServer iss = new InternetShopServer();

        com.liu.month8.d0814.goods.Observer userCamila = new com.liu.month8.d0814.goods.User("Camila");
        com.liu.month8.d0814.goods.Observer userJFla = new com.liu.month8.d0814.goods.User("J.FLa");
        com.liu.month8.d0814.goods.Observer userLisa = new com.liu.month8.d0814.goods.User("Lisa");

        iss.buyGoods(userCamila);
        iss.buyGoods(userLisa);
        iss.buyGoods(userJFla);

        iss.sendGood();
    }
}
