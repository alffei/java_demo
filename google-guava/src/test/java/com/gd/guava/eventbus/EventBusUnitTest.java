package com.gd.guava.eventbus;

import com.google.common.eventbus.EventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EventBusUnitTest {

    private EventBus eventBus;
    private EventListener eventListener;

    @Before
    public void init() {
        eventBus = new EventBus();
        eventListener = new EventListener();
        eventBus.register(eventListener);
    }

    @After
    public void tearDown() {
        eventBus.unregister(eventListener);
    }

    @Test
    public void test() {
        eventBus.post("Hello World");
    }

}
