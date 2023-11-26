package org.test3;

import java.util.LinkedList;

/**
 * @author liu
 * @date 2023/11/22 20:16
 */
public class ThreadPool {
    /**
     *  线程池的大小 可以通过构造方法初始化
     */
    int threadPoolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();
    public ThreadPool(){
        threadPoolSize=10;
        synchronized (tasks){
            for (int i = 0; i < threadPoolSize; i++) {
                new TaskConsumeThread("消费者"+i).start();
            }
        }
    }
    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }
    }
    class TaskConsumeThread extends Thread{
        private TaskConsumeThread(String name){
            super(name);
        }
        //定义消费类型所需要的任务
        Runnable task;
        @Override
        public void run(){
            System.out.println(this.getName()+"启动了");
            while (true){
                synchronized (tasks){
                    while (tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = tasks.removeLast();
                    tasks.notify();
                }
                System.out.println(this.getName()+"成功接到任务，准备执行");

                task.run();
            }
        }
    }
}
