package com.gd.thread;

/**
 * 通过继承Thread创建线程类
 *
 * @author chenpengfei
 */
public class ThreadDemo extends Thread {
    private int count = 5;

    public ThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
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
