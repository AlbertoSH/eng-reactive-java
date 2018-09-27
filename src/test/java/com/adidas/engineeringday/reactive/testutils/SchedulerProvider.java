package com.adidas.engineeringday.reactive.testutils;

import io.reactivex.schedulers.TestScheduler;

public interface SchedulerProvider {

    TestScheduler getFreshScheduler();

}
