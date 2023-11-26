package org.homework.sy;


/**
 * @author liu
 * @date 2023/11/24 11:02
 */
public class Test {
    private static int a = 0;

    public static void main(String[] args) {
        Test test = new Test();

        for (int i = 0; i < 500; i++) {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.add();
                }
            });
            thread1.start();


            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.minus();
                }
            });
            thread2.start();
        }
    }

    public synchronized void add() {
        a--;
        System.out.println(Thread.currentThread().getName() + " 对a--，a：" + a);
    }

    public synchronized void minus() {
        a++;
        System.out.println(Thread.currentThread().getName() + " 对a++，a：" + a);
    }
}
