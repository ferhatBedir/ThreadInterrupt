package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread2 thread2 = new Thread2();
        Thread1 thread1 = new Thread1();
        thread1.runThread1();
        //thread2.runThread2();


    }
}
