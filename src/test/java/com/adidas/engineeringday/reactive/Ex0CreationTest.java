package com.adidas.engineeringday.reactive;

import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ex0CreationTest {

    private Ex0Creation creation;

    @BeforeEach
    void setUp() {
        creation = new Ex0Creation();
    }

    @Test
    void getSingleValueTest() {
        TestObserver<String> test = creation.getSingleValue().test();
        test
                .assertValue(Ex0Creation.SINGLE_VALUE)
                .dispose();
    }

    @Test
    void getMultipleValueTest() {
        TestObserver<String> test = creation.getMultipleValue().test();
        test
                .assertValues(Ex0Creation.MULTIPLE_VALUES.toArray(new String[0]))
                .dispose();
    }

    @Test
    void getComputedValueTest() {
        TestObserver<String> test = creation.getComputedValue().test();
        test
                .assertValue(Ex0Creation.SINGLE_VALUE)
                .dispose();
    }
}