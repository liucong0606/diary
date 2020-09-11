package com.liu.month8.d0827.weChat;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liucong
 * @ClassName: ClientThread
 * @Description:
 * @date: 2020/8/27 17:51
 */
public class ClientThread implements Runnable {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        chat();
    }

    private synchronized void chat() {
        try (Socket s = new Socket("localhost", 3089);
             OutputStream os = s.getOutputStream();
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        ) {
            while (true) {
                System.out.println("请发送：");
                String info = sc.next();
                bw.write(info);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
