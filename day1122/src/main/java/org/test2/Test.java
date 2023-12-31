package org.test2;

/**
 * @author liu
 * @date 2023/11/22 18:34
 */
public class Test {
    public static void main(String[] args) {
        //生产者消费者是一个非常经典的多线程设计模式
        //通产有两类线程 其中有若干个生产者线程和若干个
        //消费者线程 生产者线程负责生成用户请求
        //消费者线程扶着处理用户请求
        //篮子 有一个线程负责向篮子里装馒头
        //其他线程负责从篮子里取馒头

        //创建篮子
        Basket bt = new Basket();
        //创建生产者
        Producer p = new Producer(bt);
        //创建消费者
        Consumer c = new Consumer(bt);
        //启动生产者
        new Thread(p).start();
        //还需要给生产者足够的时间 装馒头
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //启动消费者
        new Thread(c).start();
    }
}
