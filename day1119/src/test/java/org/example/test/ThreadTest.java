package org.example.test;

import org.FightRice;
import org.junit.Test;

/**
 * @author liu
 * @date 2023/11/19 9:06
 */
public class ThreadTest {
@Test
    public void threadTest1(){
    FightRice fr1 = new FightRice("1");
    FightRice fr2 = new FightRice("2");
    FightRice fr3 = new FightRice("3");
    //线程的职责是运行完成自己的run方法
    //线程需要通过调用start方法使线程自己
    //进入到就绪状态 进入到就绪态的线程
    //才会有机会被jvm进行调度
    //单位时间内 只会有一个线程被jvm进行调度
    //java选择哪一个线程运行 运行多长时间
    //是程序不可控的
    //哪一个线程先被执行 和start顺序无关 也和线程对象的创建时间无关
    //只和jvm有关
    fr1.start();
    fr2.start();
    fr3.start();
}
}
