package org.pro3;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu
 * @date 2023/11/23 18:10
 */
public class Test {
    private static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    private static void log(String msg){
        System.out.printf("%s %s %s %n",now(),Thread.currentThread().getName(),msg);
    }
    public static void main(String[] args) {
        //悲观锁另一种实现方式 Reentrantlock
        //锁的获取和释放是通过方法调用实现的
        Lock lock = new ReentrantLock();
//        Thread t1 = new Thread(){
//            @Override
//            public void run(){
//                log("线程启动");
//                log("获取锁");
//                //线程获取锁
//                lock.lock();
//                log("获取到对象锁");
//                log("模拟五秒的业务操作");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    log("释放锁");
//                    lock.unlock();
//                }
//                log("线程运行结束");
//            }
//        };
//        Thread t2 = new Thread(){
//            @Override
//            public void run(){
//                log("线程启动");
//                log("获取锁");
//                //线程获取锁
//                lock.lock();
//                log("获取到对象锁");
//                log("模拟五秒的业务操作");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    log("释放锁");
//                    lock.unlock();
//                }
//                log("线程运行结束");
//            }
//        };
//        t1.setName("t1");
//        t1.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        t2.setName("t2");
//        t2.start();
//        Condition connection =lock.newCondition();
//        Thread t3 = new Thread() {
//        @Override
//          public void run(){
//            try {
//                log("获取锁");
//                lock.lock();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                log("使用await方法进入锁，进入等待");
//                try {
//                    connection.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                log("释放锁");
//                lock.unlock();
//            }
//            log("线程结束");
//        }
//        };
//        t3.setName("t3");
//        t3.start();
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    Thread.sleep(2000);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }finally {
//                    lock.unlock();
//                }
//            }
//        };
//        t2.setName("t2");
//        t2.start();
        Thread t1 = new Thread(){
            Boolean locked = false;

            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("成功获取锁");
                        log("模拟五秒业务");
                        Thread.sleep(5000);
                    }else {
                        log("获取失败");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (locked){
                        log("释放锁");
                        lock.unlock();
                    }
                }
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(){
            Boolean locked = false;

            @Override
            public void run() {
                try {
                    log("线程启动");
                    log("试图获取锁");
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("成功获取锁");
                        log("模拟五秒业务");
                        Thread.sleep(5000);
                    }else {
                        log("获取失败");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (locked){
                        log("释放锁");
                        lock.unlock();
                    }
                }
            }
        };
        t2.setName("t2");
        t2.start();
        //
        //2.lock 接口可以选择0性的获取锁
        //自旋锁

    }
}
