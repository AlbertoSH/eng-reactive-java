package com.adidas.engineeringday.reactive;

import com.adidas.engineeringday.reactive.testutils.RxJava2SchedulersExtension;
import com.adidas.engineeringday.reactive.testutils.SchedulerProvider;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

@ExtendWith(RxJava2SchedulersExtension.class)
class Ex2CombiningTest implements SchedulerProvider {

    private TestScheduler scheduler;
    private Ex2Combining combining;

    @BeforeEach
    void setUp() {
        combining = new Ex2Combining();
    }

    @Override
    public TestScheduler getFreshScheduler() {
        scheduler = new TestScheduler();
        return scheduler;
    }

    @Test
    void combineOneByOneTest() {
        TestObserver<String> test = combining.combineOneByOne().test();
        scheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        test
                .assertValues("010", "111", "212", "313", "414")
                .dispose();
    }

    @Test
    void combineMostRecentValuesTest() {
        TestObserver<String> test = combining.combineMostRecentValues().test();

        scheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        test
                .assertValues("010", "110", "210", "211", "311", "411", "412", "413", "414", "415", "416", "417", "418", "419")
                .dispose();
    }

    @Test
    void allValuesInterleavedTest() {
        TestObserver<Integer> test = combining.allValuesInterleaved().test();

        scheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        test
                .assertValues(0, 10, 1, 2, 11, 3, 4, 12, 13, 14, 15, 16, 17, 18, 19)
                .dispose();
    }
}