package org;

/** 实现runnable 接口
 * @author liu
 * @date 2023/11/19 9:18
 */
public class FuckRice implements Runnable {
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("别骂了，我错了，我是"+Thread.currentThread().getName());
        }
    }

}
