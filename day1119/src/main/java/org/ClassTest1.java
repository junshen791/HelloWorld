package org;

import java.util.Random;

/**
 * @author liu
 * @date 2023/11/19 10:59
 */
public class ClassTest1 {
    public static void main(String[] args) {
        Thread ma = new Thread(){
            @Override
            public void run() {
                while (true){
                    Random r = new Random();
                    System.out.println("接");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("化");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("发");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("闪电五连鞭");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        final Thread t = new Thread(){
            @Override
            public void run() {
                Random r =new Random();
                while (true){
                    int temp = 1;
                    if (temp==r.nextInt(10)){
                        System.out.println("被偷袭");
                        return;}
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ma.setDaemon(true);
        ma.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();
    }


}
