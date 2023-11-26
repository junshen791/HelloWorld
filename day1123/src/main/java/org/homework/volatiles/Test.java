package org.homework.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liu
 * @date 2023/11/24 11:51
 */
public class Test {
        private AtomicInteger a = new AtomicInteger(0);

        public static void main(String[] args) {
            Test t = new Test();


            for (int i = 0; i < 500; i++) {
                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        t.add();
                    }
                });
                thread1.start();


                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        t.minus();
                    }
                });
                thread2.start();
            }
        }

        public void add() {
            int oldValue = a.get();
            int newValue = oldValue - 1;
            a.set(newValue);
            System.out.println(Thread.currentThread().getName() + " 对a--，a：" + newValue);
        }

        public void minus() {
            int oldValue = a.get();
            int newValue = oldValue + 1;
            a.set(newValue);
            System.out.println(Thread.currentThread().getName() + " 对a++，a：" + newValue);
        }


}
