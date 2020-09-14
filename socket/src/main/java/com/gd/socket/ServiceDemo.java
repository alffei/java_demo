package com.gd.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenpengfei
 */
public class ServiceDemo {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5555);
            System.out.println("begin");
            // 等待客户端连接
            Socket socket = ss.accept();
            System.out.println("in");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("0x010x030x100x000x200x010x0E0x000x320x000x000x000x000x000x030x000x040x7B0xF4");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
