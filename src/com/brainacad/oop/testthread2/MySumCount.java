package com.brainacad.oop.testthread2;

import java.util.Arrays;

public class MySumCount implements Runnable {

    private int startIndex;
    private int stopIndex;
    private volatile int[] array;
    private volatile long resultSum;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long getResultSum() {
        return resultSum;
    }

    @Override
    public void run() {

        if (startIndex >= stopIndex) {
            return;
        }
        //System.out.println(Thread.currentThread().getName());
        for (int i = startIndex; i < stopIndex; i++) {
            this.resultSum = array[i] + this.resultSum;
        }
    }

    @Override
    public String toString() {
        return "MySumCount [" +
                "array=" + Arrays.toString(array) +
                ']';
    }
}
