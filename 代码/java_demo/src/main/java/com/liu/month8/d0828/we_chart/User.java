package com.liu.month8.d0828.we_chart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liucong
 * @ClassName: User
 * @Description:
 * @date: 2020/8/28 9:39
 */
public class User implements IObserverable, IObserver {
    private String id;
    private String nickName;

    public User() {
    }

    public User(String id, String nickName) {
        this.id = id;
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    private List<IObserver> friendList = Collections.synchronizedList(new ArrayList<>());
    private String message;

    @Override
    public void update(String nickName, String msg) {
        System.out.println(this.nickName + "：收到一条信息：" + nickName + "：" + msg);
    }

    @Override
    public void add(IObserver obj) {
        if (obj != null)
            friendList.add(obj);
    }

    @Override
    public void remove(IObserver obj) {
        if (obj != null && !friendList.isEmpty())
            friendList.remove(obj);
    }

    @Override
    public void notice() {
        friendList.forEach(friend -> {
            friend.update(this.nickName, this.message);
        });
    }

    public void sendMsg2All(String msg) {
        System.out.println(this.nickName + "发送了一条消息：" + msg);
        this.message = msg;
        notice();
    }
}
