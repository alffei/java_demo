package com.gd.socket;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * @author chenpengfei
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("139.196.241.26", 8555);
        try {
            //初始化一个socket
            Socket socket = new Socket("127.0.0.1", 5555);
            //通过socket获取字符流
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                bufferedWriter.write("sss");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = reader.readLine();
                System.out.println(str);
                Thread.sleep(1000);
            }
        } catch (ConnectException e) {
            // Socket 连接失败
            System.out.println("Socket 连接失败");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
