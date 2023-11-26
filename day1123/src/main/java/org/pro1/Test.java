package org.pro1;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**java自带线程池
 *
 *
 *
 * @author liu
 * @date 2023/11/23 15:49
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务一");
            }
        });
    }
    public static void show(Season season){
        switch (season){
            case SPRING:
                System.out.println("春天来了");
                break;
            case WINTER:
                System.out.println("冬天来了");
                break;
            default:
                System.out.println("输入有误");
        }
    }



}
