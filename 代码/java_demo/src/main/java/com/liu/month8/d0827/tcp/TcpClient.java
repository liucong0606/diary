package com.liu.month8.d0827.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liucong
 * @ClassName: TcpClient
 * @Description:
 * @date: 2020/8/27 17:41
 */
public class TcpClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 7823);
             OutputStream os = s.getOutputStream()
        ) {
            os.write("Hello".getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
