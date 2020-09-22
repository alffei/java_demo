package com.gd.thread;

/**
 * 通过实现Runnable接口创建线程类
 *
 * @author chenpengfei
 */
public class RunnableDemo implements Runnable {
    private int count = 5;

    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                System.out.println("Current count value: " + count--);
            } else {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " GameOver");
    }
}
