package com.liu.month8.d0814.goods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liucong
 * @ClassName: InternetShopServer
 * @Description:
 * @date: 2020/8/14 11:32
 */
public class InternetShopServer implements Observerable {
    private List<Observer> list = Collections.synchronizedList(new ArrayList<>());
    private static final String MSG_SEND_SUCCESS = "已发货";

    @Override
    public void buyGoods(Observer o) {
        list.add(o);
    }

    @Override
    public void notifyObserver() {
        list.forEach(o -> {
            o.update(MSG_SEND_SUCCESS);
        });
    }

    public void sendGood() {
        System.out.println("商家已经发货");
        notifyObserver();
    }
}
