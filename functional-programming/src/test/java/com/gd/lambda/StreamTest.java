package com.gd.lambda;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StreamTest {

    List<String> values;

    @Before
    public void init() {
        int max = 10000000;
        values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    @Test
    public void sortedByStream() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(values.stream().sorted().count());
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    @Test
    public void sortedByParallelStream() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(values.parallelStream().sorted().count());
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }
}
