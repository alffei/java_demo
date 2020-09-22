package com.gd.thread;

import org.junit.Test;

public class CreateThreadTest {

    @Test
    public void test1() {
        new ThreadDemo("name1").start();
        new ThreadDemo("name2").start();
        new ThreadDemo("name3").start();
    }

    @Test
    public void test2() {
        new RunnableDemo().run();
        new RunnableDemo().run();
        new RunnableDemo().run();
    }

    @Test
    public void test3() {
        RunnableDemo runnableDemo = new RunnableDemo();
        new Thread(runnableDemo).start();
        new Thread(runnableDemo).start();
        new Thread(runnableDemo).start();
    }

}
