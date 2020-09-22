package com.gd.socket.tcp;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author chenpengfei
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000));
        System.out.println("Socket Connect Success");
        System.out.println("客户端信息：" + socket.getLocalAddress() + "Port:" + socket.getLocalPort());
        System.out.println("服务器信息：" + socket.getInetAddress() + "Port:" + socket.getPort());

        try {
            send(socket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }

    public static void send(Socket socket) throws IOException {
        // 键盘输入
        InputStream in = System.in;
        BufferedReader inBufferedReader = new BufferedReader(new InputStreamReader(in));

        // Socket输出流
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream);

        // Socket输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (true) {
            // 读取键盘一行输入
            String line = inBufferedReader.readLine();
            // 发送到服务器
            printStream.println(line);

            // 从服务器读取一行
            String readLine = bufferedReader.readLine();
            if ("bye".equalsIgnoreCase(readLine)) {
                System.out.println("Bye Bye");
                break;
            } else {
                System.out.println(readLine);
            }
        }

        // 资源释放
        outputStream.close();
        inputStream.close();
    }
}
