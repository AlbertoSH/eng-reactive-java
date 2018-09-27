package com.adidas.engineeringday.reactive.testutils;

import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.function.Function;

public class RxJava2SchedulersExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Scheduler scheduler = context.getTestInstance()
                .filter(obj -> obj instanceof SchedulerProvider)
                .map(obj -> (SchedulerProvider) obj)
                .map((Function<SchedulerProvider, Scheduler>) SchedulerProvider::getFreshScheduler)
                .orElse(Schedulers.trampoline());

        RxJavaPlugins.setIoSchedulerHandler(s -> scheduler);
        RxJavaPlugins.setNewThreadSchedulerHandler(s -> scheduler);
        RxJavaPlugins.setComputationSchedulerHandler(s -> scheduler);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        RxJavaPlugins.reset();
    }
}
