package MOTA;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/19 14:31
 */
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        final Monster goblin = new Monster();
        goblin.setName("哥布林");
        goblin.setHp(1000000);

        int n = 1000000;
        List<Thread> addThreads = new ArrayList<Thread>();
        List<Thread> reduceThreads = new ArrayList<Thread>();
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.recover();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads.add(t);
        }
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(){
                @Override
                public void run() {
                    goblin.hurt();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            reduceThreads.add(t);
        }

        for (Thread t:addThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread t:reduceThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("哥布林的最终血量是:"+goblin.getHp());
    }
}




