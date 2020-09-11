package com.liu.month8.d0828;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liucong
 * @ClassName: ThreadTest
 * @Description:
 * @date: 2020/8/28 9:14
 */
public class ThreadTest {
    /**
     * @Description: TCP服务端
     * @auther: liucong
     * @date: 2020/8/28 9:27
     * @return:
     */
    @Test
    public void test01() throws Exception {
        ServerSocket ss = new ServerSocket(8057);
        new Thread(() -> {
            try (Socket accept = ss.accept();
                 InputStream is = accept.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))
            ) {
                System.out.println(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        ss.close();
    }


}
