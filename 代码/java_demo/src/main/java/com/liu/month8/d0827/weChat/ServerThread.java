package com.liu.month8.d0827.weChat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liucong
 * @ClassName: ServerThread
 * @Description:
 * @date: 2020/8/27 17:59
 */
public class ServerThread implements Runnable {

    @Override
    public void run() {
        receive();
    }

    private synchronized void receive() {
        try (ServerSocket ss = new ServerSocket(3089);
             Socket accept = ss.accept();
             InputStream inputStream = accept.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            System.out.println(br.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
