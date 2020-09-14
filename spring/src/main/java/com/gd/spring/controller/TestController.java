package com.gd.spring.controller;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Q: Spring 的 Controller 是单例还是多例？
 *
 * @author chenpengfei
 */
@RestController
@RequestMapping("test")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController {

    /**
     * Controller 默认是单例的（singleton），不要使用非静态成员变量
     * 会发生数据逻辑混乱（线程不安全）
     * <p>
     * 解决方案：
     * 方案一：通过显式设置Scope为prototype，将Controller变成多例模式
     * 方案二：在Controller中使用ThreadLocal变量
     * <p>
     * spring bean作用域有以下5个：
     * 1.singleton:单例模式，当spring创建applicationContext容器的时候，
     * spring会欲初始化所有的该作用域实例，加上lazy-init就可以避免预处理；
     * 2.prototype：原型模式，每次通过getBean获取该bean就会新产生一个实例，
     * 创建后spring将不再对其管理；
     * 3.request：搞web的大家都应该明白request的域了吧，就是每次请求都新产
     * 生一个实例，和prototype不同就是创建后，接下来的管理，spring依然在监听；
     * 4.session:每次会话，同上；
     * 5.global session:全局的web域，类似于servlet中的application。
     */
    private int counter = 0;

    /**
     * Creates a thread local variable.
     */
    private ThreadLocal<Integer> counterThreadLocal = ThreadLocal.withInitial(() -> new Integer(0));

    /**
     * 默认无参构造函数
     */
    public TestController() {
        System.out.println("A: " + Thread.currentThread().getName());
    }

    @GetMapping("add1")
    public int add1() {
        System.out.println("add1: " + Thread.currentThread().getName());
        return ++counter;
    }

    @GetMapping("sub1")
    public int sub1() {
        System.out.println("sub1: " + Thread.currentThread().getName());
        return --counter;
    }

    @GetMapping("add11")
    public int add11() {
        System.out.println("add11: " + Thread.currentThread().getName());
        counterThreadLocal.set(counterThreadLocal.get() + 1);
        return counterThreadLocal.get();
    }

    @GetMapping("sub11")
    public int sub11() {
        System.out.println("sub11: " + Thread.currentThread().getName());
        counterThreadLocal.set(counterThreadLocal.get() - 1);
        return counterThreadLocal.get();
    }
}
