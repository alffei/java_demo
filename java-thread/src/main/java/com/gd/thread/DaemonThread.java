package com.gd.thread;

/**
 * 用户线程退出了，守护线程就算没执行完，JVM也会退出
 *
 * @author chenpengfei
 */
public class DaemonThread {

    public static void main(String[] args) {
        //创建一个用户线程
        Thread userThread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    try {
                        Thread.sleep(200);
                        System.out.println("用户线程第" + i + "次运行.....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("用户线程退出.....");
            }
        };
        //创建一个用户模拟守护线程的线程
        Thread daemonThread = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 99999; i++) {
                    try {
                        Thread.sleep(50);
                        System.out.println("守护线程第" + i + "次运行.....");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("守护线程退出.....");
            }
        };
        //让daemonThread成为守护线程
        //这里必须在启动前设置，如果不设置，默认人是用户线程
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}
