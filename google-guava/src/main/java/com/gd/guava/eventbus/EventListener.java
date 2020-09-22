package com.gd.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 事件监听
 *
 * @author chenpengfei
 */
public class EventListener {
    private static int eventsHandled;

    @Subscribe
    public void stringEvent(String event) {
        System.out.println(event);
        eventsHandled++;
    }

}
