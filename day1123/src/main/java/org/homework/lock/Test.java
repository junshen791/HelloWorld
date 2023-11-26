package org.homework.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author liu
 * @date 2023/11/24 11:16
 */
public class Test {
    private static int a;
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        Condition connection =lock.newCondition();
        for (int i = 0; i < 500; i++) {
            Thread t1 = new Thread(){
                @Override
                public void run() {
                    try {
                        lock.lock();
                        while ( a>=500){
                            connection.await();
                        }
                        a++;
                        System.out.println(Thread.currentThread().getName()+"对a++，a："+a);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            };
            t1.start();
        }
        for (int i = 0; i < 500; i++) {
            Thread t2 = new Thread(){
                @Override
                public void run() {
                    try {
                        lock.lock();
                        while ( a<=0){
                            connection.await();
                        }
                        a--;
                        System.out.println(Thread.currentThread().getName()+"对a--："+a);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            };
            t2.start();
        }

    }

}
