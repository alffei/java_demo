package com.gd.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author chenpengfei
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2000);
        System.out.println("服务器启动就绪， 等待客户端连接");

        // Listens for a connection to be made to this socket and accepts
        //it. The method blocks until a connection is made.
        // Socket client = server.accept();

        while (true) {
            // 获得客户端
            Socket client = server.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            clientHandler.start();
        }

    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("客户端信息：" + socket.getInetAddress() + "Port:" + socket.getPort());

            try {
                // Socket输出流，用于服务器端应答消息
                PrintStream printStream = new PrintStream(socket.getOutputStream());

                // Socket输入流，用于接收数据
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    String readLine = bufferedReader.readLine();
                    if ("bye".equalsIgnoreCase(readLine)) {
                        printStream.println("bye");
                        break;
                    } else {
                        printStream.println("应答：" + readLine);
                    }
                }
                // 释放资源
                printStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    System.out.println("客户端：" + socket.getInetAddress() + "Port:" + socket.getPort() + "已退出");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
