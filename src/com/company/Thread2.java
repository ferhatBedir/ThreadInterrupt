package com.company;

import java.util.LinkedList;
import java.util.List;

public class Thread2 {

    //Thread interrup olduktan sonra devam ediyor.

    private List<Integer> list = new LinkedList<>();

    Thread thread2 = new Thread(() -> {
        System.out.println("Thread çalışmaya başladı.. " + '\n' + "İşlem yapılıyor..");
        for (int i = 1; i <= 20; i++) {
            list.add(i);
            System.out.println("Listeye " + i + "'inci eleman eklendi..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("İşlem yapılırken beklenmeyen hata oluştu..");
            }
        }
        if (list.size() == 20) {
            System.out.println("İşlem başarı ile tamamlandı..");
        } else {
            System.out.println("işlem tamamlanamadı..");
        }

    });

    public void runThread2() throws InterruptedException {
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
        thread2.join();

    }
}
