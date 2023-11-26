package org.test2;

/**
 * @author liu
 * @date 2023/11/22 19:00
 */
public class Consumer implements Runnable{
    Basket bt;
    public Consumer(Basket bt){
        this.bt=bt;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou mt = bt.pop();
            System.out.println("消费者消费了"+mt);
        }
    }
}