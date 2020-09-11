package com.liu.month8.d0827.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liucong
 * @ClassName: TcpServer
 * @Description:
 * @date: 2020/8/27 17:34
 */
public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(7823);
             Socket s = ss.accept();
        ) {
            InputStream inputStream = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            System.out.println("你有一条新消息：");
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
