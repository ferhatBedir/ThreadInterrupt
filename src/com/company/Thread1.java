package com.company;

import java.util.LinkedList;
import java.util.List;

public class Thread1 {

    //Thread interrup olduktan sonra uygulama sonlanıyor.

    private List<Integer> list = new LinkedList<>();

    Thread thread1 = new Thread(() -> {
        System.out.println("Thread çalışmaya başladı.. " + '\n' + "İşlem yapılıyor..");
        for (int i = 1; i <= 2000000; i++) {
            list.add(i);
            System.out.println("Listeye " + i + "'inci eleman eklendi..");
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Uygulama durduruldu.");
                return;
            }

        }
        if (list.size() == 20) {
            System.out.println("İşlem başarı ile tamamlandı..");
        } else {
            System.out.println("işlem tamamlanamadı..");
        }
    });

    public void runThread1() {
        try {
            thread1.start();
            Thread.sleep(2000);
            thread1.interrupt();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
