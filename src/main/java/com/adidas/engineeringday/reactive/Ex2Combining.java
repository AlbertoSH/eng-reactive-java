package com.adidas.engineeringday.reactive;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ex2Combining {

    // You're not allowed to modify these values
    private final Observable<Integer> values1 = Observable
            .interval(10, TimeUnit.MILLISECONDS)
            .take(5)
            .map(Long::intValue);

    private final Observable<Integer> values2 = Observable
            .interval(20, TimeUnit.MILLISECONDS)
            .map(i -> i + 10)
            .take(10)
            .map(Long::intValue);


    public Observable<String> combineOneByOne() {
        // You have to combine the values from `values1` and `values2` one by one and concatenate them as if they were strings
        // i.e. the first value will be "010" (0 from values1 and 10 from values2)

        ///////// Write the solution in this block
        return Observable.zip(
                values1.map(Object::toString),
                values2.map(Object::toString),
                (s1, s2) -> s1 + s2
        );
        ///////// Write the solution in this block
    }

    public Observable<String> combineMostRecentValues() {
        // You have to combine the most recent values emitted by `values1` and `values2`
        // Each values should be combined in the same way as in the previous example

        ///////// Write the solution in this block
        return Observable.combineLatest(
                values1.map(Object::toString),
                values2.map(Object::toString),
                (s1, s2) -> s1 + s2
        );
        ///////// Write the solution in this block
    }

    public Observable<Integer> allValuesInterleaved() {
        // You don't need to combine any values in this exercise. Just join `values1` and `values2` into one Observable

        ///////// Write the solution in this block
        return Observable.merge(values1, values2);
        ///////// Write the solution in this block
    }
}
