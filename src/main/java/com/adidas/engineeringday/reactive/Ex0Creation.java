package com.adidas.engineeringday.reactive;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Ex0Creation {

    // You're not allowed to modify these values
    static final String SINGLE_VALUE = "I'm a single value!";
    static final List<String> MULTIPLE_VALUES = Arrays.asList("v1", "v2", "v3", "v4", "v5");

    public Observable<String> getSingleValue() {
        // Emit SINGLE_VALUE
        ///////// Write the solution in this block
        return Observable.just(SINGLE_VALUE);
        ///////// Write the solution in this block
    }


    public Observable<String> getMultipleValue() {
        // Emit all the values contained in MULTIPLE_VALUES
        ///////// Write the solution in this block
        return Observable.fromIterable(MULTIPLE_VALUES);
        ///////// Write the solution in this block
    }


    public Observable<String> getComputedValue() {
        // Emit the result of invoking `func`
        // You MUST NOT invoke `func.call()` directly
        // i.e. the following solution is not valid
        // return Observable.just(func.call())
        Callable<String> func = () -> SINGLE_VALUE;

        ///////// Write the solution in this block
        return Observable.fromCallable(func);
        ///////// Write the solution in this block
    }

}
