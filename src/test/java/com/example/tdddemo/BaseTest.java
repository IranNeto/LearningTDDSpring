package com.example.tdddemo;

public interface BaseTest {

    default void startup() {
        arrange();
        act();
    }

    void arrange();

    void act();

}
