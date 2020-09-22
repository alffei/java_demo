package com.gd.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * The data written to the PipedOutputStream by one thread
 * can be read from the connected PipedInputStream by another thread.
 */
public class PipeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        final PipedOutputStream output = new PipedOutputStream();
        // An PipedInputStream should be connected to a PipedOutputStream
        final PipedInputStream input = new PipedInputStream();
        input.connect(output);

        Runnable target;
        Thread thread1 = new Thread(() -> {
            try {
                output.write("Hello".getBytes());
                output.flush();
//                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int read = input.read();
                while (read != -1) {
                    System.out.println((char) read);
                    read = input.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread.sleep(1000);
        thread1.start();
        Thread.sleep(1000);
        thread1.run();
    }
}
