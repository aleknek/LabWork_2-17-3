package com.brainacad.oop.testthread2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] myArray = new int[1000];
        MySumCount mySumCount1 = new MySumCount();
        MySumCount mySumCount2 = new MySumCount();

        Thread thread1 = new Thread(mySumCount1);
        Thread thread2 = new Thread(mySumCount2);

        Random random = new Random();

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(20);
        }

        mySumCount1.setArray(myArray);
        mySumCount1.setStartIndex(10);
        mySumCount1.setStopIndex(15);

        mySumCount2.setArray(myArray);
        mySumCount2.setStartIndex(255);
        mySumCount2.setStopIndex(260);

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // System.out.println(Thread.currentThread().getName());

        System.out.print("[");
        int startIndex1 = mySumCount1.getStartIndex();
        int stopIndex1 = mySumCount1.getStopIndex();

        for (int i = startIndex1; i < stopIndex1; i++) {
            System.out.print(myArray[i] + ", ");
        }

        int startIndex2 = mySumCount2.getStartIndex();
        int stopIndex2 = mySumCount2.getStopIndex();

        for (int i = startIndex2; i < stopIndex2; i++) {
            if (i + 1 == stopIndex2) {
                System.out.print(myArray[i]);
            } else {
                System.out.print(myArray[i] + ", ");
            }
        }
        System.out.println("]");

        System.out.println();
        System.out.println("Sum of array elements: " + (mySumCount1.getResultSum() + mySumCount2.getResultSum()));

    }

}
