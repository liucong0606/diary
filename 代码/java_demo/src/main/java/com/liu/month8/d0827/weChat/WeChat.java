package com.liu.month8.d0827.weChat;

/**
 * @author liucong
 * @ClassName: WeChat
 * @Description:
 * @date: 2020/8/27 18:04
 */
public class WeChat {
    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread();
        ClientThread clientThread = new ClientThread();
        new Thread(serverThread).start();
        new Thread(clientThread).start();
    }
}
