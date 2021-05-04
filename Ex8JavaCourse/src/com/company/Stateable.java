package com.company;

public interface Stateable {
    int ACTIVE = 1;
    int NOTACTIVE = 0;

    void printState(int n);
}
