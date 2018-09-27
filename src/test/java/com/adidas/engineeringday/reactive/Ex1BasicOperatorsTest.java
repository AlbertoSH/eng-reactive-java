package com.adidas.engineeringday.reactive;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1BasicOperatorsTest {

    private Ex1BasicOperators basicOperators;

    @BeforeEach
    void setUp() {
        basicOperators = new Ex1BasicOperators();
    }


    @Test
    void multipliedBy2Test() {
        TestObserver<Integer> test = basicOperators.multipliedBy2().test();
        test
                .assertValues(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
                .dispose();
    }


    @Test
    void modifiedBy2WithAnotherObservableTest() {
        TestObserver<Integer> test = basicOperators.multipliedBy2WithAnotherObservable().test();
        test
                .assertValues(0, 2, 4, 6, 8, 10, 12, 14, 16, 18)
                .dispose();
    }

    @Test
    void divisibleBy3Test() {
        TestObserver<Integer> test = basicOperators.divisibleBy3().test();
        test
                .assertValues(0, 3, 6, 9)
                .dispose();
    }

    @Test
    void first4ValuesTest() {
        TestObserver<Integer> test = basicOperators.first4Values().test();
        test
                .assertValues(0, 1, 2, 3)
                .dispose();
    }

    @Test
    void last4ValuesTest() {
        TestObserver<Integer> test = basicOperators.last4Values().test();
        test
                .assertValues(6, 7, 8, 9)
                .dispose();
    }

    @Test
    void onlyIfTheValueChangedTest() {
        TestObserver<Integer> test = basicOperators.onlyIfTheValueChanged().test();
        test
                .assertValues(1, 2, 3, 1, 2, 3)
                .dispose();
    }

    @Test
    void ignoreDuplicatesTest() {
        TestObserver<Integer> test = basicOperators.ignoreDuplicates().test();
        test
                .assertValues(1, 2, 3)
                .dispose();
    }
}