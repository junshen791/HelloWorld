package org.test3;

import com.sun.jndi.ldap.pool.Pool;

/**
 * @author liu
 * @date 2023/11/22 20:40
 */
public class Test {
//    public static void main(String[] args) {
//        ThreadPool pool = new ThreadPool();
//        for (int i = 0; i < 5; i++) {
//            Runnable task = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("我是任务要执行的操作");
//                }
//            };
//            pool.add(task);
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("运行结束");
//    }
    //创建一个场景 假设任务运行需要1s的时间
public static void main(String[] args) {
    int sleep = 1000;
    ThreadPool pool = new ThreadPool();
    while (true){
        pool.add(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}





}