package com.adidas.engineeringday.reactive;

import io.reactivex.Observable;

public class Ex1BasicOperators {

    // You're not allowed to modify these values
    private final Observable<Integer> initialValues = Observable.range(0, 10);
    private final Observable<Integer> withDuplicates = Observable.fromArray(1, 1, 1, 2, 2, 3, 1, 2, 2, 3, 3, 3, 3);


    public Observable<Integer> multipliedBy2() {
        // Modify the emitted values so each value is multiplied by 2
        return initialValues
                ///////// Write the solution in this block
                .map(x -> x * 2)
                ///////// Write the solution in this block
                ;
    }

    public Observable<Integer> multipliedBy2WithAnotherObservable() {
        // Same exercise as the previous one BUT you MUST use the provided method multiply(int x, int y)
        return initialValues
                ///////// Write the solution in this block
                .flatMap(x -> multiply(x, 2))
                ///////// Write the solution in this block
                ;
    }

    public Observable<Integer> multiply(int x, int y) {
        return Observable.just(x * y);
    }

    public Observable<Integer> divisibleBy3() {
        // Allow only values that are divisible by 3
        return initialValues
                ///////// Write the solution in this block
                .filter(x -> x % 3 == 0)
                ///////// Write the solution in this block
                ;
    }

    public Observable<Integer> first4Values() {
        // Emit only the first 4 values
        return initialValues
                ///////// Write the solution in this block
                .take(4)
                ///////// Write the solution in this block
                ;
    }


    public Observable<Integer> last4Values() {
        // Emit only the last 4 values
        return initialValues
                ///////// Write the solution in this block
                .takeLast(4)
                ///////// Write the solution in this block
                ;
    }

    public Observable<Integer> onlyIfTheValueChanged() {
        // Emit only a value if it's different from the previous one
        // i.e. if the values are [1, 1, 2, 1] emit [1, 2, 1]
        return withDuplicates
                ///////// Write the solution in this block
                .distinctUntilChanged()
                ///////// Write the solution in this block
                ;
    }

    public Observable<Integer> ignoreDuplicates() {
        // Do not send any repeated values
        // i.e. if the values are [1, 1, 2, 1] emit [1, 2]
        return withDuplicates
                ///////// Write the solution in this block
                .distinct()
                ///////// Write the solution in this block
                ;
    }
}
